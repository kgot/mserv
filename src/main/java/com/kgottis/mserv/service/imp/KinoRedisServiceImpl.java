package com.kgottis.mserv.service.imp;

import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.domain.RedisKey;
import com.kgottis.mserv.service.KinoRedisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
/**
 *
 * Created by kostas on 13/2/2017.
 */
@Component
public class KinoRedisServiceImpl implements KinoRedisService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    private final Logger logger = LogManager.getLogger(KinoRedisServiceImpl.class.getName());

    @Override
    public KinoDraw saveDraw(KinoDraw kinoDraw) {
        if (kinoDraw == null) return null;
        if (isLast(kinoDraw.getDrawNo())) return kinoDraw;

        redisTemplate.multi();
        redisTemplate.opsForValue().set(RedisKey.LAST_KINODRAW, kinoDraw);
        redisTemplate.exec();

        return kinoDraw;
    }

    @Override
    public KinoDraw getLast() {
        return (KinoDraw) redisTemplate.opsForValue().get(RedisKey.LAST_KINODRAW);
    }

    @Override
    public Boolean isLast(Long drawNo) {
        KinoDraw cachedKinoDraw = (KinoDraw) redisTemplate.opsForValue().get(RedisKey.LAST_KINODRAW);
        return cachedKinoDraw != null && cachedKinoDraw.getDrawNo().equals(drawNo);
    }
}
