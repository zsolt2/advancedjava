package hu.meiit.haladojava.flow;

public class FlowFactory {
    public static BaseFlow getFlow(String type) {
        switch (type) {
            case ("csv->xml"):
                return new Csv_to_xml();
            case ("xml->map"):
                return new Xml_to_map();
            case ("map->aggregate"):
                return new Map_to_aggregate();
            case ("aggregate->csv"):
                return new Aggregate_to_csv();
            case ("aggregate->xml"):
                return new Aggregate_to_xml();
            default:
                return null;
        }
    }
}
