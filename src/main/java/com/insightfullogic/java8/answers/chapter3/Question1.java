package com.insightfullogic.java8.answers.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Question1 {
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                      .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                      .collect(toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
                    .filter(album -> album.getTrackList().size() <= 3)
                    .collect(toList());
    }

    public static List<Map<String, Object>> getMergeList() {
        Map<String, Object>  map1=  new HashMap<>();
        Map<String, Object>  map2=  new HashMap<>();
        Map<String, Object>  map3=  new HashMap<>();
        map1.put("brNo", "1");
        map1.put("brName", "name1");
        map2.put("brNo", "2");
        map2.put("brName", "name2");
        map3.put("brNo", "3");
        map3.put("brName", "name3");
        List<Map<String, Object>> list1 = new ArrayList<>();
        list1.add(map1);
        list1.add(map2);
        list1.add(map3);


        Map<String, Object>  other1=  new HashMap<>();
        Map<String, Object>  other2=  new HashMap<>();
        Map<String, Object>  other3=  new HashMap<>();
        other1.put("brNo", "1");
        other1.put("onLineNo", "1");
        other1.put("offLineNo", "1");
        other1.put("testLineNo", "1");
        other2.put("brNo", "2");
        other2.put("onLineNo", "2");
        other2.put("offLineNo", "2");
        other2.put("testLineNo", "2");
        other3.put("brNo", "3");
        other3.put("onLineNo", "3");
        other3.put("offLineNo", "3");
        other3.put("testLineNo", "3");
        List<Map<String, Object>> list2 = new ArrayList<>();
        list2.add(other1);
        list2.add(other2);
        list2.add(other3);

        list1.forEach(m1 -> list2.stream()
                .filter(m2 -> m1.get("brNo").equals(m2.get("brNo")))
                .findFirst()
                .ifPresent(m2 -> {
                    m1.put("onLineNo", m2.get("onLineNo"));
                    m1.put("offLineNo", m2.get("offLineNo"));
                    m1.put("testLineNo", m2.get("testLineNo"));
                }));

        return list1;
    }
}
