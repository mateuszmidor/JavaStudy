package mm.api;

public class TestJson {

    static final public String JSON_SCHEMA = "" +
            "{" +
            "      '$schema': 'http://json-schema.org/draft-04/schema#'," +
            "      'type': 'array'," +
            "      'items': {" +
            "            'type': 'object'," +
            "            'properties' : {" +
            "                  'number' : {'type' : 'integer'}," +
            "                  'name' : {'type' : 'string'}" +
            "            }" +
            "      }" +
            "}";

    static final public String JSON_VALID_DATA = "" +
            "[" +
            "      {'number':15, 'name':'jan'}," +
            "      {'number':74, 'name':'olgiert'}" +
            "]";

    static final public String JSON_INVALID_DATA = "" +
            "[" +
            "      {'number':15, 'name':'jan'}," +
            "      {'number':74, 'name':6}" + // error: expected string name not number
            "]";

    static final public String INT_OR_STRING_LIST_DATA = "" +
            "[" +
            "  'first', 3, 5, 'second', 7" +
            "]";

    static final public String INT_OR_STRING_LIST_SCHEMA = "" +
            "{" +
            "  '$schema': 'http://json-schema.org/draft-04/schema#'," +
            "  'type': 'array'," +
            "  'items': {" +
            "    'oneOf': [" +
            "      {'type': 'string'}," +
            "      {'type': 'integer'}" +
            "    ]" +
            "  }" +
            "}";

    static final public String FRUIT_OR_SWEET_LIST_DATA = "" +
            "[" +
            "  {" +
            "    'fruit' :" +
            "      {" +
            "        'name' : 'kiwi'," +
            "        'color' : 'green'" +
            "      }" +
            "  }," +
            "  {" +
            "    'sweet' :" +
            "    {" +
            "      'name' : 'candy'," +
            "      'calories' : 700" +
            "    }" +
            "  }" +
            "]";

    static final public String FRUIT_OR_SWEET_LIST_SCHEMA = "" +
            "{" +
            "  '$schema': 'http://json-schema.org/draft-04/schema#'," +
            "  'type': 'array'," +
            "  'minItems': 2," +
            "  'items': {" +
            "    'oneOf': [{" +
            "      'type': 'object'," +
            "      'properties' : {" +
            "        'fruit' : {" +
            "          'type': 'object'," +
            "          'properties' : {" +
            "            'name' : {'type' : 'string'},            " +
            "            'color' : {'type' : 'string'}" +
            "          }," +
            "          'required' : ['name', 'color']" +
            "        }," +
            "        'sweet' : {" +
            "          'type': 'object'," +
            "          'properties' : {" +
            "            'name' : {'type' : 'string'},   " +
            "            'calories' : {'type' : 'integer'}" +
            "          }," +
            "          'required': ['name', 'calories']" +
            "        }" +
            "      }" +
            "    }]" +
            "  }" +
            "}";
}
