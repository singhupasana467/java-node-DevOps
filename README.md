# Java + Node.js Full-Stack App with Docker & GitHub Actions

## Overview

This project is a simple full-stack application composed of:

- Java Backend: A lightweight HTTP server using `com.sun.net.httpserver` that responds with "Hello from Java Backend" on port 8080.
- Node.js Frontend: An Express-based server that fetches data from the Java backend and displays it on a web page, running on port 3000.

## Source Code

Find the full implementation in the GitHub repository:  
https://github.com/singhupasana467/java-node-DevOps

## Tech Stack

| Layer     | Technology         | Purpose                                |
|-----------|--------------------|----------------------------------------|
| Backend   | Java (JDK 8+)       | Serves a plain-text HTTP response       |
| Frontend  | Node.js + Express   | Fetches and displays backend data       |
| Container | Docker              | Containerizes both services             |
| CI/CD     | GitHub Actions      | Automates build and push to Docker Hub |
| Secrets   | GitHub Secrets      | Stores Docker credentials securely      |

## Project Structure

```
java-node-DevOps/
├── backend/
│   └── Dockerfile
├── frontend/
│   └── Dockerfile
└── .github/
    └── workflows/
        └── deploy.yaml
```

## Docker Implementation

Each service has its own Dockerfile:

- Java Backend: `backend/Dockerfile`
- Node.js Frontend: `frontend/Dockerfile`

## How to Run Locally with Docker

### Java Backend

```
docker build -t java-backend ./backend
docker run -p 8080:8080 java-backend
```

### Node.js Frontend

```
docker build -t node-frontend ./frontend
docker run -p 3000:3000 node-frontend
```

## GitHub Secrets Required

| Name             | Description                        |
|------------------|------------------------------------|
| DOCKER_USERNAME  | Your Docker Hub username           |
| DOCKER_PASSWORD  | Docker Hub password or access token|

Set these in your repository under:  
GitHub → Settings → Secrets → Actions

## GitHub Actions CI/CD

The workflow file `deploy.yaml` automates:

- Building both backend and frontend Docker images
- Authenticating to Docker Hub using secrets
- Pushing images to Docker Hub for deployment

## Notes

- Ensure both containers are running for full functionality.
- The frontend expects the backend to be accessible at `http://localhost:8080`.
