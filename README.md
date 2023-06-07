# UserGitHubAPI
## Author: Marcin Bator
### Overview

This API provides access to GitHub repository data. For passed username it returns JSON object with a list of all his repositories which are not forks. You can get such an information as repository's owner username or last commit's sha.

### How to launch

First, you must have Java 17 and JDK 19 installed on your machine. Moreover, Spring Framework 5.0.4 or higher, Maven 3.2+ and Tomcat 8.5 are required.

To send a proper GET request, you have to use software that provides adding header adnotation "Accept: application/json". In other case, the response wouldn't work. I'm using Postman for Windows.

When you have everything installed, run the server - it will be accessible at localhost:8080. To send the request, you have to type following URL:

##### localhost:8080/api/USER_NAME

where USER_NAME means username of account of which repositories you want to see.

In case you have provided the invalid username, API will respond with a 404 status. Program will raise an exception if you set Accept header to application/xml.
