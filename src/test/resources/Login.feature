Feature: Test Login feature for a mobile application on an IOS device

  @RegressionTest
  Scenario: User login and authentication
    Given As an end user I want to open the WebdriverIO application on my IOS device
    When I navigate to Login page and enter the credentials
    Then I should be able to login successfully

