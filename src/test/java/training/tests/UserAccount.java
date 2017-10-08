package training.tests;

// Данные аккаунта пользователя

public class UserAccount {

    // Tax ID
    private String taxId = null;
    // Company
    private String company = null;
    // First Name
    private String firstname = null;
    // Last Name
    private String lastname = null;
    // Address 1
    private String address1 = null;
    // Address 2
    private String address2 = null;
    // Postcode
    private String postcode = null;
    // City
    private String city = null;
    // Country
    private String country = null;
    // Zone/State/Province
    private String zoneCode = null;
    // Email
    private String email = null;
    // Phone
    private String phone = null;
    // Password
    private String password = null;

    /**
     * Получить Tax ID
     *
     * @return {@link String}
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Установить Tax ID
     *
     * @param taxId
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    /**
     * Получить Company
     *
     * @return {@link String}
     */
    public String getCompany() {
        return company;
    }

    /**
     * Установить Company
     *
     * @param company
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setCompany(String company) {
        this.company = company;
        return this;
    }

    /**
     * Получить First Name
     *
     * @return {@link String}
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Установить First Name
     *
     * @param firstname
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    /**
     * Получить Last Name
     *
     * @return {@link String}
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Установить Last Name
     *
     * @param lastname
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    /**
     * Получить Address 1
     *
     * @return {@link String}
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Установить Address 1
     *
     * @param address1
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    /**
     * Получить Address 2
     *
     * @return {@link String}
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Установить Address 2
     *
     * @param address2
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    /**
     * Получить Postcode
     *
     * @return {@link String}
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Установить Postcode
     *
     * @param postcode
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * Получить City
     *
     * @return {@link String}
     */
    public String getCity() {
        return city;
    }

    /**
     * Установить City
     *
     * @param city
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Получить Country
     *
     * @return {@link String}
     */
    public String getCountry() {
        return country;
    }

    /**
     * Установить Country
     *
     * @param country
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Получить Zone/State/Province
     *
     * @return {@link String}
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * Установить Zone/State/Province
     *
     * @param zoneCode
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
        return this;
    }

    /**
     * Получить Email
     *
     * @return {@link String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Установить Email
     *
     * @param email
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Получить Phone
     *
     * @return {@link String}
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Установить Phone
     *
     * @param phone
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Получить Password
     *
     * @return {@link String}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Установить Password
     *
     * @param password
     *
     * @return {@link UserAccount} this
     */
    public UserAccount setPassword(String password) {
        this.password= password;
        return this;
    }

    public UserAccount() {
        setTaxId(TestBase.getRandomNumber());
        setCompany("Company " + TestBase.getRandomNumber());
        setFirstname("John" + TestBase.getRandomNumber());
        setLastname("Petrov" + TestBase.getRandomNumber());
        setAddress1("Address" + TestBase.getRandomNumber());
        setAddress2("Address" + TestBase.getRandomNumber());
        setPostcode(TestBase.getRandomBigNumber().substring(0,5));
        setCity("City" + TestBase.getRandomNumber());
        setCountry("United States");
        setEmail(getLastname() + "_" + TestBase.getRandomNumber() + "@email.com");
        setPhone("+1" + TestBase.getRandomBigNumber().substring(0,10));
        setPassword(TestBase.getRandomNumber());

    }



}
