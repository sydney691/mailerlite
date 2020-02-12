package com.sydneyzamoranos.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sydneyzamoranos.pojo.Groups;
import com.sydneyzamoranos.pojo.Subscribers;

@RestController
@RequestMapping("/mailerlite")
public class MailerLiteRestController {

  @Autowired
  private RestTemplate restTemplate;


  @GetMapping("/groups")
  public List<Groups> getGroups() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-MailerLite-ApiKey", "2e4bb105a6d054abcb408a03e6520829");
    HttpEntity entity = new HttpEntity(headers);
    ResponseEntity<List> response = restTemplate.exchange("https://api.mailerlite.com/api/v2/groups", HttpMethod.GET,entity,List.class);
    return response.getBody();
  }
  
  @PostMapping("/groups/save")
  public void saveGroup(@RequestBody Subscribers subscribers) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-MailerLite-ApiKey", "2e4bb105a6d054abcb408a03e6520829");
    headers.set("content-type", "application/json");
    HttpEntity<Subscribers> entity = new HttpEntity(subscribers,headers);
    String url = "https://api.mailerlite.com/api/v2/groups/"+subscribers.getId()+"/subscribers";
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,entity,String.class);
    System.out.println(response.getBody());
    
  }
}
