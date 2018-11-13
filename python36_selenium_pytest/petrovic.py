from selenium import webdriver
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.options import Options
from locators import LoginPage
import pytest

class TestPetro:

	@pytest.fixture(scope="session")
	def setup(self):
		global driver,wait
		print("initiating chrome driver")
		options = Options()
		#options.add_argument('--headless')
		driver = webdriver.Chrome("chromedriver.exe",options=options)
		height = 1366
		width = 768
		driver.set_window_size(height, width)
		wait = WebDriverWait(driver, 10)

		yield
		driver.close()
		driver.quit()

	def test_login_page(self,setup):
		driver.get("https://petrovich.ru/login/")
		assert "Петрович" in driver.title

	def test_login(self,setup):
		login_value="test_task@petrovich.ru"
		wait.until(EC.visibility_of_element_located(LoginPage.LOGIN)).send_keys(login_value)
		login_element = driver.find_element(*LoginPage.LOGIN).get_attribute('value')
		assert login_element == login_value, "Login is incorrect"

	def test_pass(self,setup):
		pass_value="111111"
		wait.until(EC.visibility_of_element_located(LoginPage.PASS)).send_keys(pass_value)
		pass_element = driver.find_element(*LoginPage.PASS).get_attribute('value')
		assert pass_value == pass_element, "Login is incorrect"

	def test_checkbox(self,setup):
		wait.until(EC.element_to_be_clickable(LoginPage.CHECKED)).click()
		is_checked = driver.find_element(*LoginPage.ISCHECKED).is_selected()
		assert is_checked == False

	def test_clear_login(self,setup):
		wait.until(EC.visibility_of_element_located(LoginPage.LOGIN)).clear()
		login_element = driver.find_element(*LoginPage.LOGIN).get_attribute('value')
		assert login_element == "", "Login is't cleared!"

	def test_newlogin(self,setup):
		login_value="test_task"
		wait.until(EC.visibility_of_element_located(LoginPage.LOGIN)).send_keys(login_value)
		login_element = driver.find_element(*LoginPage.LOGIN).get_attribute('value')
		assert login_element == login_value, "Login is incorrect"

	def test_click_button(self,setup):
		wait.until(EC.element_to_be_clickable(LoginPage.BUTTON)).click()
		driver.implicitly_wait(3)
		prof_name = wait.until(EC.visibility_of_element_located(LoginPage.PROFILE)).get_attribute('textContent')
		assert "test_task" in prof_name

