import java.time.LocalDateTime;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Solution {
    public String[] photoType = new String[]{"jpg", "png", "jpeg"};

    public static void main(String[] args) {
        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15" + "\r\n" +
                "john.png, Warsaw, 2015-06-20 15:13:22" + "\r\n" +
                "john.png, Paris, 2017-06-20 15:13:22" + "\r\n" +
                "john.png, Paris, 2018-06-20 15:13:22"
                ;
        Solution ss = new Solution();
        ss.solution(s);
        String[] photoType = new String[]{"jpg", "png", "jpeg"};
    }

    public String solution(String S) {
        String[] lines = S.split(System.getProperty("line.separator"));
        System.out.println(lines.length);
        ArrayList<Photo> photos = getPhotoArrayList(lines);
        Map<String, List<Photo>> photoMap = arrangeAccordingToDateAndCity(photos);

        OptionalInt maxLength = photoMap.keySet().stream().mapToInt(String::length).max();
        int maxCityLength = maxLength.orElse(-1);


        for(List<Photo> photoByCity: photoMap.values()){
            photoByCity.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
            for(int i = 0; i < photoByCity.size(); i++){
                String cityName = padLeftZeros(photoByCity.get(i).location, maxCityLength);
                System.out.println(cityName + (i+1));
            }
        }

        return "aa0";
    }

    private Map<String, List<Photo>> arrangeAccordingToDateAndCity(ArrayList<Photo> photos) {
        Map<String, List<Photo>> photoMap = photos.stream().collect(groupingBy(Photo::getLocation));
        for(List<Photo> photoByCity: photoMap.values()){
            photoByCity.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
        }
        return photoMap;
    }

    private ArrayList<Photo> getPhotoArrayList(String[] lines) {
        ArrayList<Photo> photos = new ArrayList<>();
        for (String photoName : lines) {
            String[] list = photoName.split(",");
            if(!isProperPhotoType(list[0]))
                continue;
            photos.add(new Photo(list[0], list[1].trim(), convertStringToDateTime(list[2].
                    replaceAll("^\\s+", "").
                    replaceAll(" ", "T"))));
        }
        return photos;
    }

    public static LocalDateTime convertStringToDateTime(String date){
        return LocalDateTime.parse(date);
    }

    public String padLeftZeros(String inputString, int length) {
        StringBuilder sb = new StringBuilder();
        StringBuilder inputSb =  new StringBuilder(inputString);
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        inputSb.append(sb);

        return inputSb.toString();
    }

    public static boolean isProperPhotoType(String s) {
        boolean result = false;

        String[] photoType = new String[]{"jpg", "png", "jpeg"};
        String[] photoTypeList = s.split("\\.");
        if (Arrays.asList(photoType).contains(photoTypeList[1])) {
            result = true;
        }
        return result;
    }

    public class Photo{
        private String photoName;
        private String location;
        private LocalDateTime date;

        public Photo(String photoName, String location, LocalDateTime date) {
            this.photoName = photoName;
            this.location = location;
            this.date = date;
        }

        public String getLocation() {
            return location;
        }

        public LocalDateTime getDate() {
            return date;
        }

        @Override
        public String toString() {
            return "Photo{" +
                    "photoName='" + photoName + '\'' +
                    ", location='" + location + '\'' +
                    ", date=" + date +
                    '}';
        }
    }
}