from selenium import webdriver

driver = webdriver.Chrome(executable_path='./usr/local/bin/chromedriver')
driver.get('http://www.google.com/')

driver.quit()