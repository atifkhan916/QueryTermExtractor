#System requirement
JDK 1.8 (minimum)

# Build step to download dependencies and create a jar file "extractor-1.0.jar" inside target folder
# 1.Download code from git repo
# 2. Go to the project folder
# 3. Run below command in linux
./mvnw clean compile package
# 3. Run below command in windows command prompt
mvnw clean compile package

# to run jar file run the below command
java -jar ./target/extractor-1.0.jar

# To run the code in any editor like VS code or eclipse
# Open the project as a Java project in any java editor
# and run the App.java class

# To run the test code in any editor like VS code or eclipse
# Open the project as a Java project in any java editor
# and run the AppTest.java class

# ExtractQueryTermsService.java file is the main file containing the business logic
# If another application wants to use it then add this project as a dependency
# and use the below code to get the JSON response
ExtractQueryTermsService extractQueryTermsService = new ExtractQueryTermsService();
String response = extractQueryTermsService.extractQueryTerms();

# For test results please see the test-results folder
