from flask import Flask, request, jsonify, render_template
from flask_cors import CORS
from pymongo import MongoClient

app = Flask(__name__)
CORS(app)

# MongoDB connection details
mongo_uri = 'mongodb+srv://Aymen:Aymen@smartassign.hsrxs8a.mongodb.net'
database_name = 'SmartAssign'
collection_name = 'users'

# Connect to MongoDB
client = MongoClient(mongo_uri)
db = client[database_name]
collection = db[collection_name]

# Load the employee data from MongoDB
employees = list(collection.find())

# Function to recommend employees based on skills
def recommend_employees(desired_skills, top_n=5):
    def calculate_match_score(employee_skills, desired_skills):
        return len(set(employee_skills) & set(desired_skills))

    recommendations = []

    for employee in employees:
        profile = employee['profile']
        employee_skills = profile['skills']
        match_score = calculate_match_score(employee_skills, desired_skills)
        recommendations.append((employee, match_score))

    # Sort employees by match score in descending order
    recommendations.sort(key=lambda x: x[1], reverse=True)

    # Return top N recommendations
    return [emp[0] for emp in recommendations[:top_n]]

@app.route('/', methods=['GET', 'POST'])
def index():
    recommended_employees = []
    selected_skills = None

    if request.method == 'POST':
        selected_skills = request.form.getlist('skills')
        recommended_employees = recommend_employees(selected_skills)

    # Extract the list of skills for the UI (can be optimized or customized)
    skills_set = set(skill for emp in employees for skill in emp['profile']['skills'])

    return render_template('index.html', skills_list=skills_set, selected_skills=selected_skills, recommended_employees=recommended_employees)

@app.route('/recommend', methods=['POST'])
def recommend_employees_post():
    data = request.get_json()
    desired_skills = data.get('skills')

    if not desired_skills:
        return jsonify({"error": "Skills are required"}), 400

    recommended_employees = recommend_employees(desired_skills)
    
    # Prepare the response data
    response_data = [{
        "name": emp['profile']['name'],
        "lastname": emp['profile']['lastname'],
        "skills": emp['profile']['skills']
    } for emp in recommended_employees]

    return jsonify({
        "desired_skills": desired_skills,
        "recommended_employees": response_data
    })

@app.route('/recommend/<string:skills>', methods=['GET'])
def recommend_employees_get(skills):
    # Parse the skills passed in the URL (assuming they are comma-separated)
    desired_skills = skills.split(',')

    recommended_employees = recommend_employees(desired_skills)

    # Prepare the response data
    response_data = [{
        "name": emp['profile']['name'],
        "lastname": emp['profile']['lastname'],
        "skills": emp['profile']['skills']
    } for emp in recommended_employees]

    return jsonify({
        "desired_skills": desired_skills,
        "recommended_employees": response_data
    })

if __name__ == '__main__':
    app.run(debug=True)
