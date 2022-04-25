package com.insightfullogic.java8.examples.chapter1;

import com.insightfullogic.java8.answers.chapter3.Question1;
import com.insightfullogic.java8.answers.chapter3.Question1Test;
import org.junit.Test;

import java.util.*;

import static com.insightfullogic.java8.examples.chapter1.SampleData.theBeatles;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toSet;
import static junit.framework.Assert.assertEquals;

public class TestPerformance {

    @Test
    public void allMembers() {
        Album album = new Album("foo", Collections.<Track>emptyList(), singletonList(theBeatles));
        Set<Artist> musicians = album.getAllMusicians().collect(toSet());
        Set<Artist> expectedMusicians = new HashSet<>(SampleData.membersOfTheBeatles);
        expectedMusicians.add(theBeatles);
        assertEquals(expectedMusicians, musicians);
    }

    @Test
    public void mergeListTest() {
        List<Map<String, Object>> result = Question1.getMergeList();
        Map<String, Object>  map1=  new HashMap<>();
        Map<String, Object>  map2=  new HashMap<>();
        Map<String, Object>  map3=  new HashMap<>();
        map1.put("brNo", "1");
        map1.put("brName", "name1");
        map1.put("onLineNo", "1");
        map1.put("offLineNo", "1");
        map1.put("testLineNo", "1");
        map2.put("brNo", "2");
        map2.put("brName", "name2");
        map2.put("onLineNo", "2");
        map2.put("offLineNo", "2");
        map2.put("testLineNo", "2");
        map3.put("brNo", "3");
        map3.put("brName", "name3");
        map3.put("onLineNo", "3");
        map3.put("offLineNo", "3");
        map3.put("testLineNo", "3");
        List<Map<String, Object>> list1 = new ArrayList<>();
        list1.add(map1);
        list1.add(map2);
        list1.add(map3);
        assertEquals(list1, result);
    }
}
