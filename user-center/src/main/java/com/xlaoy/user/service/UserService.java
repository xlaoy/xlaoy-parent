package com.xlaoy.user.service;

import com.xlaoy.common.exception.BizException;
import com.xlaoy.common.utils.JSONUtil;
import com.xlaoy.user.dao.CustomerDao;
import com.xlaoy.user.dto.UserDTO;
import com.xlaoy.user.mapper.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate*/;

    //@Autowired
    //private DelayTaskRegister delayTaskRegister;

    public void test01() {
        throw new BizException("你牛逼");
    }

    public void register(UserDTO userDTO) {
        /*String guid = IDWorkUtil.getUUID();
        redisTemplate.opsForHash().put(RedisHashName.USER, guid, userDTO);*/
    }

    public void setUserAndUrl() {
//        redisTemplate.opsForHash().put(RedisHashName.USER_PERMISSION, "asdasdfasfaq243fsdf43qwef", Arrays.asList("ROLE_ORDINARY_USER", "ROLE_TRADE_USER"));
//        redisTemplate.opsForHash().put(RedisHashName.URL_PERMISSION, "/api-user/user/test04", Arrays.asList("ROLE_ORDINARY_USER","ROLE_DD"));
    }

    public void rabbit() {
        /*UserDTO dto = new UserDTO();
        dto.setUserName("haha");
        dto.setNickName("ll");
        rabbitTemplate.convertAndSend(RabbitConfig.WO_CAO, dto);
        logger.info("消息发送成功：" + JSONUtil.toJsonString(dto));*/
    }

    //@RabbitListener(queues = RabbitConfig.WO_CAO)
    //@RabbitHandler
    public void rabbitProcess(UserDTO dto) {
        logger.info("收到消息：" + JSONUtil.toJsonString(dto));
    }

    /*public void registerDelayTask() throws Exception {
        String taskId = delayTaskRegister.register(DelayTaskData.bizName("usernotify")
                .bizParameters("12341234")
                .executeTime(new SimpleDateFormat(Java8TimeUtil.YYYY_MM_DD_HH_MM_SS).parse("2018-08-23 20:00:00")));
        logger.info("taskId:" + taskId);
    }

    public void cancel(String taskId) {
        delayTaskRegister.cancel(taskId);
    }*/


    //@Autowired
    //private IKafkaOffSetRepository kafkaOffSetRepository;

    /*@KafkaListener(topics = "request_url_log", groupId = "tongji")
    public void reciveUrlLog(ConsumerRecord<String, String> record) {
        logger.info("收到kafka消息，record=" + record);
        KafkaOffSetEntity offSetEntity =  kafkaOffSetRepository.findByTopicAndGroupId("request_url_log", "tongji");
        if(offSetEntity == null) {
            offSetEntity = new KafkaOffSetEntity();
        }
        offSetEntity.setTopic("request_url");
        offSetEntity.setGroupId("xlaoy-1");
        offSetEntity.setOffset(record.offset());
        kafkaOffSetRepository.save(offSetEntity);
    }*/


    @Autowired
    private CustomerDao customerDao;


    public Integer findByName() {
        return hahaha();
    }

    @Transactional
    public Integer save() {
        Integer a = customerDao.findByName("haha").getAge();
        Customer customer = new Customer();
        customer.setName("nimahai" + new Random().nextInt(100));
        customer.setAge(12);
        customerDao.insert(customer);
        return a;
    }

    @Transactional
    public Integer hahaha() {
        return customerDao.findByName("haha").getAge();
    }

}
