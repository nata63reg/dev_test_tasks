from selenium.webdriver.common.by import By

class LoginPage:
	LOGIN 		=	(By.CSS_SELECTOR, ".grid>div>div p+form>div>input")
	PASS 		=	(By.CSS_SELECTOR, ".grid>div>div p+form>div+div>input")
	CHECKED 	=	(By.XPATH, "(//*[@id='login__enter']/div[3]/label)[2]")
	ISCHECKED	=	(By.XPATH,"(//*[@id='login__enter']/div[3]/label/span/input)[2]")
	BUTTON		=	(By.XPATH, "(//*[@id='login__enter']/div[3]/button)[2]")
	PROFILE		=	(By.XPATH, "//*[@id='user__email']/a/span[1]")