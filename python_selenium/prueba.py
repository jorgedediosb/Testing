from selenium import webdriver

chrome_driver = '/usr/local/bin/chromedriver'

driver = webdriver.Chrome(chrome_driver)

driver.get("https://www.example.com")

driver.close()