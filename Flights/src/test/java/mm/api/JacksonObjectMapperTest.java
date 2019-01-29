package mm.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;


class Fruit {
    public String name;
    public String color;
}

class Sweet {
    public String name;
    public int calories;
}

class FruitOrSweet {
    public Fruit fruit;
    public Sweet sweet;
}

class FruitOrSweetList extends ArrayList<FruitOrSweet> {
}

public class JacksonObjectMapperTest {

    @Test
    public void deserializeTest() {
        ObjectMapper mapper = new ObjectMapper();
        FruitOrSweetList res = null;
        try {
            String data = QuoteConverter.singleToDouble(TestJson.FRUIT_OR_SWEET_LIST_DATA);
            res = mapper.readValue(data, FruitOrSweetList.class);
        } catch (IOException e) {
            fail(e.getMessage());
        }

        // should be 2 items on the list
        assertEquals(2, res.size());

        FruitOrSweet element0 = res.get(0);
        FruitOrSweet element1 = res.get(1);

        // element0 has Fruit and no Sweet
        assertNotNull(element0.fruit);
        assertNull(element0.sweet);

        // element1 has Sweet and no Fruit
        assertNotNull(element1.sweet);
        assertNull(element1.fruit);

        // check Fruit params
        assertEquals("kiwi", element0.fruit.name);
        assertEquals("green", element0.fruit.color);

        // check Sweet params
        assertEquals("candy", element1.sweet.name);
        assertEquals(700, element1.sweet.calories);
    }
}
