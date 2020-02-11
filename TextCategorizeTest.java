import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
*   Tests for TextCategorize
*   cs335 take-home quiz
*   @author Caitlin Anderson
*/


class TextCategorizeTest {

    private TextCategorize txtCat;
    /*
     *   instantiates object before each test
     */
    @BeforeEach
    public void init() {
        txtCat = new TextCategorize("dog ant cat antelope goose Ant bear koala");
    }
    /*
    *   Tests that it categorizes the correct number of words into categories
    */
    @Test
    void categorize() { //all other tests also help confirm that this works
        assertEquals(0,txtCat.getWordCount());
        txtCat.categorize();
        assertEquals(8,txtCat.getWordCount());
        assertTrue(txtCat.hasCategories());
    }
    /*
     *   Tests that all categories were created and that getCategories can access them
     */
    @Test
    void getCategories() {
        txtCat.categorize();
        ArrayList<String> cats = new ArrayList<String>(Arrays.asList("a","b","c","d","g","k"));
        assertEquals(cats,txtCat.getCategories());
    }
    /*
     *   Tests that getCategories() doesn't break when object is empty
     */
    @Test
    void getCategoriesForEmpty() {
        assertEquals(new ArrayList<>(),txtCat.getCategories());
    }
    /*
     *   Tests that getWordCount() returns the correct integer
     */
    @Test
    void getWordCount() {
        txtCat.categorize();
        assertEquals(8,txtCat.getWordCount());
    }
    /*
     *   Tests that getWordCount() doesn't break when object is empty
     */
    @Test
    void getWordCountForEmpty() {
        assertEquals(0,txtCat.getWordCount());
    }
    /*
     *   Tests that hasCategories() returns true when categorize() has run
     */
    @Test
    void hasCategories() {
        txtCat.categorize();
        assertTrue(txtCat.hasCategories());
    }
    /*
     *   Tests that hasCategories() doesn't break when object is empty
     */
    @Test
    void hasCategoriesEmpty() {
        assertFalse(txtCat.hasCategories());
    }
    /*
     *   Tests that getWords() doesn't break when user inputs an invalid key
     */
    @Test
    void getWordsNotKey() {
        txtCat.categorize();
        assertEquals(new ArrayList<>(),txtCat.getWordsFor("x"));
    }
    /*
     *   Tests that getWords() can return a simple value correctly
     */
    @Test
    void getWordsForLengthOne() {
        txtCat.categorize();
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("bear"));
        assertEquals(words,txtCat.getWordsFor("b"));
    }
    /*
     *   Tests that values are being categorized in the correct order
     */
    @Test
    void getWordsForMultiple() {
        txtCat.categorize();
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("ant","antelope","Ant"));
        assertEquals(words,txtCat.getWordsFor("a"));
    }
}
