# ☁️ Cloud Share – Next Generation File Storage & Sharing  


## **Cloud Share – Full Stack File Sharing Application**

Cloud Share is a full-stack cloud-based file storage and sharing application developed using **Spring Boot**, **React**, **MySQL**, **Tailwind CSS**, and **Clerk Authentication (JWT)**. The platform allows users to securely upload, manage, and share files with ease, while also offering a subscription and credits-based system for accessing advanced features. Its architecture ensures both security and scalability, making it a practical solution for modern file management needs.


## ✨ Features  

- 🔐 **Secure Authentication** – User registration, login, and session management with Clerk (JWT).  
- 📤 **File Upload** – Drag & drop or click to upload files easily.  
- 📑 **Recent Files Dashboard** – Displays uploaded files with details:  
  - File Name  
  - Size  
  - Uploaded By  
  - Modified Date  
  - Sharing Status (Private / Public)  
- 📂 **My Files Management** – Manage uploaded files with options to download / delete / share.  
- 💳 **Subscription System** – Free credits available, users can upgrade plans for more storage & uploads.  
- 🧾 **Transactions History** – View payments and subscription details.  
- 📌 **Responsive Sidebar Navigation** – Dashboard, Upload, My Files, Subscription, Transactions.  
- 🎨 **Modern UI** – Clean interface built with Tailwind CSS, optimized for desktop & mobile.  

---

## 🛠️ Tech Stack  

- **Frontend:** React (Vite), Tailwind CSS  
- **Backend:** Spring Boot, REST APIs  
- **Database:** MySQL  
- **Authentication:** Clerk (JWT)  
- **Version Control:** Git & GitHub

 ## ✨ Highlights
- Full-stack implementation with modern tech stack
- Secure file sharing with JWT-based authentication
- Subscription & credit system for advanced features
- Responsive UI built with Tailwind CSS
- Easy setup with clear instructions
  

  ## 🗂️ Project Structure

  cloud-share/
│
├── cloud-share-web-app-frontend/     # React + Vite Frontend
│   ├── src/
│   │   ├── assets/                   # Images and icons
│   │   ├── components/               # UI components
│   │   ├── context/                  # Global state management
│   │   ├── pages/                    # Application pages
│   │   ├── util/                     # Utility/helper functions
│   │   ├── App.jsx                   # Root React component
│   │   ├── main.jsx                  # Entry point
│   │   ├── index.css                 # Global styles
│   │   └── .env                      # Environment variables
│   ├── public/                       # Static assets
│   ├── package.json                  # NPM dependencies
│   └── vite.config.js                # Vite configuration
│
└── cloud-share-web-app-backend/      # Spring Boot Backend
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── cloud/fileshare/cloud_share_web_app_backend/
    │   │   │       └── CloudShareWebAppBackendApplication.java  # Main Spring Boot App
    │   │   ├── resources/
    │   │   │   ├── static/          # Static resources (if any)
    │   │   │   ├── templates/       # Thymeleaf or HTML templates
    │   │   │   └── application.properties  # Backend configuration
    │   ├── test/                    # Unit and integration tests
    │
    ├── Dockerfile                   # Containerization config
    ├── pom.xml                      # Maven dependencies
    ├── uploads/                     # Uploaded file storage
    └── target/                      # Build output






 ## 📸 Project Screenshots & Demo

## 🏠 Home Page 

<img width="1128" height="632" alt="Screenshot 2025-09-28 105314Cloud Share 1" src="https://github.com/user-attachments/assets/ca981989-314d-4118-b96f-def0023ad424" />


<img width="1132" height="544" alt="Screenshot 2025-09-28 105424Cloud Share 2" src="https://github.com/user-attachments/assets/b853ed36-882e-449d-bc55-1c2a71367517" />


<img width="1228" height="611" alt="Screenshot 2025-09-28 105513Cloud Share 3" src="https://github.com/user-attachments/assets/8a566a2e-567e-4060-b0d6-c8f485886f16" />


### 📊 Dashboard 

<img width="1329" height="622" alt="Screenshot 2025-09-28 105823Dashboard1" src="https://github.com/user-attachments/assets/5cc6b4dd-6213-4b1b-9510-97cf7af14ed8" />


### 📤 Upload  

<img width="1333" height="608" alt="Screenshot 2025-09-28 105916Upload2" src="https://github.com/user-attachments/assets/02b0c65a-6558-4959-bd22-2e507aaf6677" />


### 📂 My Files  

<img width="1337" height="590" alt="Screenshot 2025-09-28 105945MyFiles" src="https://github.com/user-attachments/assets/7335617f-7c1d-4189-bb6e-248f488ec6e2" />


### 💳 Subscription  

<img width="1336" height="621" alt="Screenshot 2025-09-28 110019Subscription" src="https://github.com/user-attachments/assets/f70635aa-0028-48cf-a884-5ffde3c5d2ce" />

### 🧾 Transactions  

<img width="1332" height="620" alt="Screenshot 2025-09-28 110054Transaction" src="https://github.com/user-attachments/assets/f7847ac3-2cba-4549-a767-a99b1d8860d0" />


## ⚙️ Installation & Setup

This section helps anyone set up and run the project locally with ease, ensuring reproducibility and showcasing full-stack expertise.

---

1️⃣ Clone the Repository
git clone https://github.com/<your-username>/cloud-share.git
cd cloud-share

2️⃣ Backend Setup
cd cloud-share-backend


Ensure Java 21+ and Maven are installed.

Configure MySQL database:

spring.datasource.url=jdbc:mysql://localhost:3306/cloud_share_db
spring.datasource.username=root
spring.datasource.password=yourpassword

Run the backend server:

mvn spring-boot:run

Backend runs at: http://localhost:8080

3️⃣ Frontend Setup
cd ../cloud-share-frontend
npm install

Create .env file:

VITE_API_URL=http://localhost:8080
VITE_CLERK_FRONTEND_API=<your-clerk-frontend-api>
VITE_CLERK_PUBLISHABLE_KEY=<your-clerk-publishable-key>


Start the frontend:

npm run dev

Frontend runs at: http://localhost:5173









