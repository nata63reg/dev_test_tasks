#### Task:
        Please create Automation test. Use OOP and Page Object Pattern.
	Tools: Python 3+, Selenium 3+, Pytest 3+.
	Autotest must be running with resolution 1366px х 768px and successfully finished after iteration

#### Test case:
	1. Open Google Chrome v70+;
	2. Navigate to: "https://petrovich.ru/login/";
	3. In field «Login / E-mail» type "test_task@petrovich.ru";
	4. In field «Password» type: "111111";
	5. Uncheck «Запомнить меня»;
	6. Clear field «Login / E-mail»;
	7. In field «Login / E-mail» type "test_task";
	8. Click button «ВХОД»
	
#### Notice:
	ul Each step must be checked. (e.g: After step 3 check that field is populated properly).
	- Use only CSS and XPATH locators.
	- Use implicity and explicity waits.
