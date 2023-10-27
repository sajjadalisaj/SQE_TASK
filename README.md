# SQE_Task
## File Structure 

### 1. jar_files
#### All the jar files related to this project.

### 2. src/driver
#### The chrome driver.exe to communicate test scripts with Google Chrome.

### 3. src/Login.java
#### All variables are stored here which are used in the login process including X-path.

### 4. src/AddToCart.java
#### All variables are stored here which are used in the add to cart process including X-path.

### 5. src/CheckOut.java
#### All variables are stored here which are used in the check out process including X-path.

### 6. src/Methods.java
#### All the functions are written here including initiating the web browser, navigating to the URL, clicking on button and more.

### 7. src/parameters.java
#### The remaining variables are stored here which are the driver name, site URL etc. 

### 8. src/Main.java
#### All the classes, methods, and variables are imported here in order to generate a script for testing.

### Process
#### - First we have called ```Methods.initiateWebBrowserSession()``` in order to initiate the browser. Then by calling *Methods.navigateToURL(parameters.siteURL)* by giving it argument parameters.siteURL in order to access the site. We called *Methods.verifyTitle(parameters.expectedTitle)* and gave it a parameter of parameters.expectedTitle in order to verify whether the site is the same or not. Then We call the Login class and created its object as *Login login = new Login(parameters.driver)* and in order to login we called *Methods.enterText(login.userID, login.userName)* and *Methods.enterText(login.passwordId, login.userPassword)* in order to write user name and password in the text filed and the last step for login was clicking on login button *Methods.clickElement(login.loginbtn)*.

#### - After login I used *Methods.waitforTime(parameters.ms)* in order to wait some seconds and then I verified the landing page is inventory page or not for this I used *Methods.verifyElementExpectedText(parameters.titleXpath,parameters.ExpectedHeading)* giving two arguments the xpath and the expected heading. Then I called the AddToCart class in order to test the cart *AddToCart addToCart = new AddToCart()*. By using random library I have selected any random number from 1 to 6 and then assign that random number in *X*Path* of the inventory item in order to select that item and storing its values in variables like *WebElement productName = parameters.driver.findElement(By.xpath(addToCart.productNameX))* *String productText = productName.getText()* to store the product name and *WebElement priceName = parameters.driver.findElement(By.xpath(addToCart.productPriceX))* *String priceText = priceName.getText()* to store product price. After selecting the product name and price I called *Methods.clickElement(addToCart.productBtnX)* in order to add this product in cart.

#### - After adding product in cart I have to verify that either the selected product is in cart or not for this I called *Methods.clickElement(addToCart.addToCartBtn)* to access the cart page and to verify the product is correct one or not I have verified product name and price using *Methods.verifyElementExpectedText(addToCart.cartProductName,productText)* for product name and *Methods.verifyElementExpectedText(addToCart.cartProductPrice,priceText)* for product price and then I called *Methods.waitforTime(parameters.ms)* to wait some second and after successfully verification I called *Methods.clickElement(addToCart.checkOutBtn)* in order to proceed for checkout.

#### - In order to perform testing of check out I have created CheckOut class *CheckOut checkOut = new CheckOut()* since the checkout page need user details so I called *Methods.enterText(checkOut.firstNameX, checkOut.firstName)* to write first, name, *Methods.enterText(checkOut.lastNameX, checkOut.lastName)* for last name and *Methods.enterText(checkOut.zipCodeX, checkOut.zipCode)* for post code and then I called *Methods.clickElement(checkOut.continueBtnX)* in order to hit continue button.

#### - Last I have used *Methods.waitforTime(parameters.ms)* to see the enterd details and then clicked on finish button using *Methods.clickElement(checkOut.finishBtnX)* and verified either the whole process is done or not by comparing the heading written on the page using *Methods.verifyElementExpectedText(checkOut.endNoteX, checkOut.endNote)* then I called *Methods.closeBrowser()* to close the browser after successfully verification of testing.
