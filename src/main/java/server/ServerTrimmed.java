package server;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;

public class ServerTrimmed {
    public static void main(String[] args) {
        Cache cache = new CacheFactory().set("cache-xml-file", "config/cache-trimmed.xml").create();
    }
}
