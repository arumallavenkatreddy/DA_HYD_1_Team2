# DA_HYD_1_Team2

# **E-Asset Management System**

E-Asset Management System is a digital solution designed to streamline the process of managing assets within an organization, offering dedicated functionalities for both users and administrators.

## **Table of Contents**
  
* [**Overview**](#overview)

* [**Snapshots**](#snapshots)
    
* [**Features**](#features)
    
    * [**User**](#user)
        
    * [**Admin**](#admin)
        
* [**Tech Stack**](#tech-stack)
    
* [**Deployment**](#deployment)
    
* [**Further Improvements**](#further-improvements)
    
* [**Project Dashboard Overview**](#project-dashboard-overview)
    
* [**Setup and Installation**](#setup-and-installation)

* [**Our Contributors**](#our-contributors)

* [**License**](#license)
    

## **Overview**

This digital platform ensures seamless tracking of assets like laptops, books, mobiles, and more. It allows for asset availability, location, borrower details, and borrowing history to be readily accessible, all within a user-friendly interface.

## **Snapshots**

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1694708030808/27fec769-5a81-4af6-a2ba-054aabb4da58.jpeg align="center")

## **Features**

### **User**

* **Asset Browsing**: View the array of available assets.
    
* **Asset Borrowing**: Check asset availability and borrow seamlessly.
    
* **Asset Return**: View due dates and manage the return of borrowed assets.
    
* **Notifications**: Receive timely updates about borrowing status and due dates.
    

### **Admin**

* **Asset Management**: Add, edit, or remove assets within the system.
    
* **User Management**: View user borrowing history and manage user permissions.
    
* **Overdue Management**: Handle and notify users of overdue assets.
    
* **Reports & Analytics**: Access insightful reports on asset usage, borrowings, and returns.
    

## **Tech Stack**

### **Front-end:**

* **HTML, CSS**: Used for creating structured, styled web pages.
    
* **JavaScript**: Handles front-end interactivity and form validation.
    
* **Optional CSS Framework**: Leveraged Bootstrap for creating responsive designs, ensuring smooth user experience across various devices.
    

### **Back-end:**

* **MVC Framework**: Adopted Layered Architecture for an organized and modular application flow.
    
* **RDBMS Server**: Employed MySQL to manage structured business data, facilitating reliable and efficient data storage and retrieval.
    

### **Other Utilities:**

* **Regex**: Integrated for accurately validating email addresses and telephone numbers, enhancing data integrity.
    
* **Security**: Incorporated specialized tools and libraries to safeguard user credentials, enforce authorized access, and proficiently manage user authentication and authorization.
    

## **Deployment**

### **CI/CD (Continuous Integration/Continuous Deployment):**

To maintain a high standard of code quality and ensure smooth deployments for the E-Asset Management System, we've integrated a CI/CD pipeline. This automated process guarantees that every feature, fix, or enhancement in our asset management tool is thoroughly vetted before reaching our users.

### **Vercel Deployment (Frontend):**

The E-Asset Management System's front-end provides users and admins with a visual interface to interact with assets and is seamlessly deployed using Vercel.

By adopting Vercel for our frontend deployments, we ensure that the E-Asset Management System remains accessible, efficient, and up-to-date as a reliable tool for all asset management needs.

## **Further Improvements**

1. **Real-time Backend-Frontend Interlinking**:
    
    The system can be enhanced by leveraging modern web technologies to provide real-time updates and interactions between the front-end and back-end. This ensures immediate reflection of changes, instantaneous notifications, and a seamless user experience.
    
2. **Notifications**:
    
    Enhance the notification system to include email or SMS alerts, expanding the reach and urgency of vital notifications.
    
3. **Mobile App**:
    
    Consider developing a mobile application version for on-the-go access, catering to users who might prefer mobile platforms over web browsers.
    
4. **Multilingual Support**:
    
    Add support for multiple languages, ensuring the platform can cater to a global audience and be accessible to non-English speakers.
    
5. **Cloud Integration**:
    
    To handle growing data and user access needs, migrate databases and servers to cloud platforms, ensuring scalability and enhanced performance.
    

## **Project Dashboard Overview**

Our [**project dashboard**](https://github.com/users/Shankar-Rajan/projects/1) on GitHub is a central hub to monitor and manage various aspects of our project:

1. **Issues**:
    
    * **Overview**: We used issues to track various elements, from enhancements and tasks to the diverse questions that arose during the project.
        
    * **Assigned**: We designated specific team members for each issue, ensuring clarity in roles and responsibilities.
        
2. **Pull Requests**:
    
    * **Overview**: We utilized pull requests to communicate the changes we pushed to branches in our repository, facilitating collaborative code reviews and integrations.
        
    * **Linked Issues**: When a pull request addresses a particular issue, we connect them for coherent tracking.
        
    * **Reviewers**: We assigned one reviewer to each pull request. The individual was responsible for examining the changes and providing essential feedback to ensure our code met the necessary quality standards before merging.
        
3. **Task Status**: We visualized our task progress using a Kanban-style board. This board showed tasks in various phases, such as "To do," "In progress," and "Done."
    
4. **Date Completed**: As we resolved task issues or merged pull requests, we timestamped them, giving us a detailed timeline of our project milestones.
    
5. **Assignees**: Team members were consistently assigned to tasks, issues, or pull requests. This process ensured everyone was clear on their responsibilities.
    
6. **Repository Link**: For reference, we provided a direct link to our central repository, which housed all the code, assets, and the comprehensive version history.
    

## **Setup and Installation**

### **Accessing the Backend**

The backend of our application is located in the "Backend" folder within the application's directory structure. To interact with the backend, follow these steps:

1. **Access the Backend Directory**: Navigate to the "Backend" folder within the application's root directory.
    
2. **Running the Backend**: The backend is implemented using Java. To run it, ensure you have Java installed on your system. Open a terminal or command prompt, navigate to the "Backend" folder, and execute the Java program through either STS or Eclipse.
    
3. **Database Connection**: The backend code is already connected to the database. Make sure that you have created the necessary database for your application. The backend code will establish a connection to this database when it runs.
    

By following these steps, you can access and run the backend of your application, which is written in Java and seamlessly connected to your database.

### **Accessing the Frontend**

The frontend code of our application can be found in the "Application" folder. It is responsible for the user interface and can be accessed and run locally and via a deployed version on Vercel. Here are the steps to interact with the frontend:

1. **Locally Accessing the Frontend**:
    
    a. **Navigate to the Frontend Directory**: Begin by navigating to the "Application" folder within the application's directory structure. This is where the front-end code is located.
    
    b. **Main Page**: The primary entry point for the front end is the `index.html` file. Open this file in a web browser to access the main page of your application.
    
    c. **User and Admin Views**: Depending on your application's functionality, you may have separate views for users and administrators. These views will have functionalities and can typically be accessed via different URLs or routes. Refer to your application's documentation or codebase to find the specific routes for these views.
    
    d. **Local Development Server**: During development, you can run the front end locally by using a development server. This allows you to test your application on your local machine.
    
    Ensure you have the necessary dependencies and tools installed, such as Node.js and npm, for your front-end project.
    
    e. **Access via Localhost**: Once the development server runs, you can access the front end by opening a web browser and navigating to the local host port.
    
2. **Deployed Version on Vercel**:
    
    a. **Real-Time Site**: The front end of your application is also deployed on Vercel. This deployment lets you access your application in real-time through a publicly accessible URL. This deployed version will reflect Any changes to the frontend code.
    
    b. **Vercel Deployment**: To access the deployed frontend on Vercel, you can use the provided URL. The deployed site can be seen here: [https://da-hyd-1-team2.vercel.app/](https://da-hyd-1-team2.vercel.app/)
    

By following these steps, you can access and run the frontend of your application, whether locally for development or via the Vercel deployment for real-time access and updates.

## **Our Contributors**

1. [**Shankar Rajan**](https://github.com/Shankar-Rajan)
    
2. [**Arumalla Venkat Reddy**](https://github.com/arumallavenkatreddy)
    
3. [**Visali Pemmaraju**](https://github.com/Visali-vish)
    
4. [**Sriram P**](https://github.com/sriramp8402)
    
5. [**Harshita Sharma**](https://github.com/harshitaa-work)
    
6. [**Bharathnath**](https://github.com/bharath9180)
    
7. [**Mutyala Umashankari**](https://github.com/mutyalaumashankari)

8. [**Laxmi Prasanna**](https://github.com/Prasanna292001)

9. [**Rasmita kar**](https://github.com/Rasmitakar)
    

Thank you to all our contributors for their valuable contributions to this project! Your dedication and efforts are greatly appreciated.

## **License**

This project is licensed under the MIT License - see the [**LICENSE.md**](http://LICENSE.md) file for details.
