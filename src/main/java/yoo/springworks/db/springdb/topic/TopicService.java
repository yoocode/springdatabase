package yoo.springworks.db.springdb.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    //hard coded data
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Tom", "manager"),
//                new Topic("java", "Jean", "associate"),
//                new Topic("javascript", "Cathy", "intern")
//        ));

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
//        return topics;
     List<Topic> topics = new ArrayList<>();
     topicRepository.findAll()
             .forEach(topics::add);
     return topics;
    }

    public Topic getTopic(String id){
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    return topicRepository.findOne(id);
    }

    public void addTopic (Topic topic){
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        topics.stream()
//              .filter(t -> t.getId().equals(id))

//        for(int i = 0; i < topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
        topicRepository.save(topic);
    }

    //using lambda expression
    public void deleteTopic(String id){
//        topics.removeIf(t -> t.getId().equals(id));
        topicRepository.delete(id);
    }

//    public void deleteTopic(String id) {
//        for (int i = 0; i < topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.remove(i);
//            }
//        }
//    }
}
