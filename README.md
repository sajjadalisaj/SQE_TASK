# SQE_Task
## File Structure 

### 1. jar_files
#### All the jar files related to this project.

### 2. src/driver
#### The chrome driver.exe to communicate test scripts with Google Chrome.

### 3. src/Login.java
#### All variables are stored here which are used in the login process.
#### All the scripts related to the login are here which includes writing in text fields and clicking on the login button.

### 4. src/AddToCart.java
#### All variables are stored here which are used in add to cart process.
#### All the scripts related to the add-to-cart are here including selecting any random item from the inventory list, storing its name and price in a variable, adding it to the cart, and then verifying whether the same product is added to the cart or not.

### 5. src/CheckOut.java
#### All variables are stored here which are used in the checkout process.
#### All the scripts related to the checkout are here from filling in customer details to the last.

### 6. src/Methods.java
#### All the functions are written here including initiating the web browser, navigating to the URL, clicking on button and more.

### 7. src/parameters.java
#### The remaining variables are stored here which are the driver name, site URL etc. 

### 8. src/Main.java
#### All the classes, methods, and variables are imported here in order to generate a script for testing.

### Process
#### First we have called *Methods.initiateWebBrowserSession()* in order to initiate the browser. Then by calling *Methods.navigateToURL(parameters.siteURL)* by giving it argument parameters.siteURL in order to access the site. We called *Methods.verifyTitle(parameters.expectedTitle)* and gave it a parameter of parameters.expectedTitle in order to verify whether the site is the same or not. Then We call the Login class and created its object as *Login login = new Login(parameters.driver)* and in order to login we called *Methods.enterText(login.userID, login.userName)* and *Methods.enterText(login.passwordId, login.userPassword)* in order to write user name and password in the text filed and the last step for login was clicking on login button *Methods.clickElement(login.loginbtn)*.

            Methods.waitforTime(parameters.ms);
            System.out.println("\nInventory Page Heading!");
            Methods.verifyElementExpectedText(parameters.titleXpath,parameters.ExpectedHeading);

            //2. Add to Cart Product
            System.out.println("\nSelecting Random Product Name and Price!");

            AddToCart addToCart = new AddToCart();

            WebElement productName = parameters.driver.findElement(By.xpath(addToCart.productNameX));
            String productText = productName.getText();

            WebElement priceName = parameters.driver.findElement(By.xpath(addToCart.productPriceX));
            String priceText = priceName.getText();

            System.out.println(productText);
            System.out.println(priceText);

            Methods.clickElement(addToCart.productBtnX);

            //3. Cart Page
            Methods.clickElement(addToCart.addToCartBtn);
            System.out.println("\nVerifying Product in Cart");
            Methods.verifyElementExpectedText(addToCart.cartProductName,productText);
            Methods.verifyElementExpectedText(addToCart.cartProductPrice,priceText);
            Methods.waitforTime(parameters.ms);
            Methods.clickElement(addToCart.checkOutBtn);

            //4. CheckOut Information

            CheckOut checkOut = new CheckOut();

            System.out.println("\nCheckout Information");
            Methods.enterText(checkOut.firstNameX, checkOut.firstName);
            Methods.enterText(checkOut.lastNameX, checkOut.lastName);
            Methods.enterText(checkOut.zipCodeX, checkOut.zipCode);
            Methods.clickElement(checkOut.continueBtnX);

            //5. Finalized Details
            System.out.println("\nEnd Note");
            Methods.waitforTime(parameters.ms);
            Methods.clickElement(checkOut.finishBtnX);
            Methods.verifyElementExpectedText(checkOut.endNoteX, checkOut.endNote);

            Methods.closeBrowser();
