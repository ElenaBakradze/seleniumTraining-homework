package training.tests;

// Новый товар

public class NewProduct {

    // Name
    private String name = null;
    // Code
    private String code = null;
    // Default Category
    private String defaultCategory = null;
    // Quantity
    private String quantity = null;
    // Date Valid From
    private String dateValidFrom = null;
    // Date Valid To
    private String dateValidTo = null;
    // Keywords
    private String keywords = null;
    // Short Description
    private String shortDescription = null;
    // Description
    private String description = null;
    // Head Title
    private String headTitle = null;
    // Meta Description
    private String metaDescription = null;
    // Purchase Price
    private String purchasePrice = null;
    // Price USD
    private String pricesUsd = null;
    // Price EUR
    private String pricesEur = null;

    /**
     * Получить Name
     *
     * @return {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Установить Name
     *
     * @param name
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Получить Code
     *
     * @return {@link String}
     */
    public String getCode() {
        return code;
    }

    /**
     * Установить Code
     *
     * @param code
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Получить Default Category
     *
     * @return {@link String}
     */
    public String getDefaultCategory() {
        return defaultCategory;
    }

    /**
     * Установить Default Category
     *
     * @param defaultCategory
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setDefaultCategory(String defaultCategory) {
        this.defaultCategory = defaultCategory;
        return this;
    }

    /**
     * Получить Quantity
     *
     * @return {@link String}
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Установить Quantity
     *
     * @param quantity
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Получить Date Valid From
     *
     * @return {@link String}
     */
    public String getDateValidFrom() {
        return dateValidFrom;
    }

    /**
     * Установить Date Valid From
     *
     * @param dateValidFrom
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setDateValidFrom(String dateValidFrom) {
        this.dateValidFrom = dateValidFrom;
        return this;
    }

    /**
     * Получить Date Valid To
     *
     * @return {@link String}
     */
    public String getDateValidTo() {
        return dateValidTo;
    }

    /**
     * Установить Date Valid To
     *
     * @param dateValidTo
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setDateValidTo(String dateValidTo) {
        this.dateValidTo = dateValidTo;
        return this;
    }

    /**
     * Получить Keywords
     *
     * @return {@link String}
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Установить Keywords
     *
     * @param keywords
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    /**
     * Получить Short Description
     *
     * @return {@link String}
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Установить Short Description
     *
     * @param shortDescription
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setShortDescription(String shortDescription) {
        this.shortDescription= shortDescription;
        return this;
    }

    /**
     * Получить Description
     *
     * @return {@link String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Установить Description
     *
     * @param description
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Получить Head Title
     *
     * @return {@link String}
     */
    public String getHeadTitle() {
        return headTitle;
    }

    /**
     * Установить Head Title
     *
     * @param headTitle
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
        return this;
    }

    /**
     * Получить Meta Description
     *
     * @return {@link String}
     */
    public String getMetaDescription() {
        return metaDescription;
    }

    /**
     * Установить Meta Description
     *
     * @param metaDescription
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
        return this;
    }

    /**
     * Получить Purchase Price
     *
     * @return {@link String}
     */
    public String getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Установить Purchase Price
     *
     * @param purchasePrice
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    /**
     * Получить Price USD
     *
     * @return {@link String}
     */
    public String getPricesUsd() {
        return pricesUsd;
    }

    /**
     * Установить Price USD
     *
     * @param pricesUsd
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setPricesUsd(String pricesUsd) {
        this.pricesUsd = pricesUsd;
        return this;
    }

    /**
     * Получить Price EUR
     *
     * @return {@link String}
     */
    public String getPricesEur() {
        return pricesEur;
    }

    /**
     * Установить Price EUR
     *
     * @param pricesEur
     *
     * @return {@link NewProduct} this
     */
    public NewProduct setPricesEur(String pricesEur) {
        this.pricesEur = pricesEur;
        return this;
    }

    public NewProduct() {
        setName("Duck" + TestBase.getRandomNumber());
        setCode(TestBase.getRandomNumber());
        setQuantity(TestBase.getRandomNumber());
        setDateValidFrom(TestBase.getCurrentDate());
        setDateValidTo(TestBase.getRandomDateInFuture());
        setKeywords("duck");
        setShortDescription("Short Description" + TestBase.getRandomNumber());
        setDescription("Description" + TestBase.getRandomNumber());
        setHeadTitle("Head Title " + getName());
        setMetaDescription("Meta Description " + getName());
        setPurchasePrice(TestBase.getRandomNumber());
        setPricesUsd(TestBase.getRandomNumber());
        setPricesEur(TestBase.getRandomNumber());
    }



}
