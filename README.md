# FiverrAPI

## Project for web scraping Fiverr profiles

### How does it work?
- JSoup connects to the Fiverr profile page and downloads the HTML code using proxy from FreeProxy
- JSoup gets elements from profile and allows users to get it in right format
### 3rd party libs used:
- [x] [JSoup](https://jsoup.org/)
- [x] [JUnit](https://junit.org/junit5/)
- [x] [Lombok](https://projectlombok.org/)
### Why taking data takes so long?
- Fiverr has a lot of security measures to prevent web scraping, so it takes a lot of time to get the data
- Scraper tries over 500+ proxies to get the data, if one is not working, it tries another one
### How to use it?
- Check out Javadocs: 

- #### If you have any suggestion, feel free to open an issue or pull request
- #### Do you have some working proxies? Feel free to open a pull request with them
