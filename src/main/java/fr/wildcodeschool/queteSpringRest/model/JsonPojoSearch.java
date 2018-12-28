package fr.wildcodeschool.queteSpringRest.model;

public class JsonPojoSearch {
    private String search1;
    private String search2;

    public JsonPojoSearch() {
    }

    public JsonPojoSearch(String search1, String search2) {
        this.search1 = search1;
        this.search2 = search2;
    }

    public String getSearch1() {
        return search1;
    }

    public String getSearch2() {
        return search2;
    }

    public void setSearch1(String search1) {
        this.search1 = search1;
    }

    public void setSearch2(String search2) {
        this.search2 = search2;
    }

}
