API Detailed

Filtering the request

    We can filter the request before reaching the controller 
    The filters are to check the source like which origin (website)
    This can be achived by implementing the bean WebMvcConfigurer
    in this bean we can block the request from unknow origin

This Application is mainly contains two types of API
    
    1.Static Data
    2.Using DB

Static Data

    1. Hard coded the list of object as json
    2. This has some validation check
    

Validation
  
    1. Validation is achived using jakarta.validation
    2. While creating the data been class we can specify the validation poins
            a. Size
            b. email
            c. positive
            d. range inbetween
    3. These can be Validated in the Request Controller while Defining the end point using the @Valid

Header restrictions

    1. If we want restrect any request to come to controller we can do that using HandlerInterceptor
            
        To get this we need implememnt preHandle method in which we will get the required header 
        and  see required values are there or not. After implementing the class we need to register this in controller been using the WebMvcConfigurer interface addInterceptors method over ride
    2. If we want to apply header validation to some or one request we can add @RequestHeader in the end point implementation

         