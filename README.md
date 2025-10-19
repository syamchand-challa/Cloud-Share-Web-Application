# ☁️ Cloud Share – Next Generation File Storage & Sharing  

A **Full Stack Cloud File Sharing Application** developed using **Spring Boot, React, MySQL, Tailwind CSS, and Clerk Authentication (JWT)**.  
It allows users to **upload, manage, and securely share files** with subscription & credits system.  

---

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
- 

 ## 📸 Project Screenshots & Demo

## 🏠 Home Page 

<img width="1128" height="632" alt="Screenshot 2025-09-28 105314Cloud Share 1" src="https://github.com/user-attachments/assets/e62d9046-5b69-4620-ae13-b66652b6c147" />


<img width="1132" height="544" alt="Screenshot 2025-09-28 105424Cloud Share 2" src="https://github.com/user-attachments/assets/7c1efaad-b6de-467d-8b2d-ba22d17da29a" />


<img width="1228" height="611" alt="Screenshot 2025-09-28 105513Cloud Share 3" src="https://github.com/user-attachments/assets/2efbe5ed-8cbb-4128-98bf-60bd558e01ea" />


<img width="1319" height="618" alt="Screenshot 2025-09-28 105609Cloud Share 4" src="https://github.com/user-attachments/assets/4251e143-3a65-423c-b09c-da1232efabcc" />

### 📊 Dashboard 

<img width="1329" height="622" alt="Screenshot 2025-09-28 105823Dashboard1" src="https://github.com/user-attachments/assets/b58d1702-a700-46c0-8379-a6b3d5dd5ef5" />

### 📤 Upload  

<img width="1333" height="608" alt="Screenshot 2025-09-28 105916Upload2" src="https://github.com/user-attachments/assets/c45ad1e9-3e88-4c92-a8fc-7f877678e0a7" />

### 📂 My Files  

<img width="1337" height="590" alt="Screenshot 2025-09-28 105945MyFiles" src="https://github.com/user-attachments/assets/20ca5be0-62e4-4341-a024-7bc31a02c0f7" />

### 💳 Subscription  

<img width="1336" height="621" alt="Screenshot 2025-09-28 110019Subscription" src="https://github.com/user-attachments/assets/ca18083f-1440-41b1-b82f-72bd77cac79a" />

### 🧾 Transactions  

<img width="1332" height="620" alt="Screenshot 2025-09-28 110054Transaction" src="https://github.com/user-attachments/assets/9c3f249a-7f07-4844-af39-b9c8313c9efd" />


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









