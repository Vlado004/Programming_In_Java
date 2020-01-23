package Vjezba7.Vjezba7;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("mqtt")
public class MqttController {

    private MqttService service;

    public MqttController(MqttService _service){
        service = _service;
    }

    @GetMapping
    public String checkFunction(){
        return "Hello World!";
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody MqttRequest message) {
        String returnVal;
        try {
            returnVal = service.publishMessage(message);
        } catch (MqttException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(returnVal, HttpStatus.OK);
    }
}
