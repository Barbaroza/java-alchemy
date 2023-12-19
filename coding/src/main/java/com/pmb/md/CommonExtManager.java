package com.pmb.md;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lvrui
 */
public class CommonExtManager {

//    public class MonoExtPoint {
//        public class BiExtPoint {
//        }
//
//        public class TriExtPoint {
//        }
//
//        private static final Map<String, MonoExtPoint> monoExtPoints = new ConcurrentHashMap<>();
//        private static final Map<String, BiExtPoint> biExtPoints = new ConcurrentHashMap<>();
//        private static final Map<String, TriExtPoint> triExtPoints = new ConcurrentHashMap<>();
//
//
//        public void setMonoExtPoints(Collection<MonoExtPoint> monoExtList) {
//            for (MonoExtPoint monoExt : emptyIfNull(monoExtList)) {
//                CommRouter router = monoExt.getClass().getAnnotation(CommRouter.class);
//                if (Objects.isNull(router)) {
//                    throw new RuntimeException("router annotation cannot be null");
//                }
//                if (Strings.isBlank(router.key())) {
//                    throw new RuntimeException("router key cannot be null");
//                }
//                String key = buildRouterKey(router.key(), router.scene());
//                if (monoExtPoints.containsKey(key)) {
//                    throw new RuntimeException(String.format("key[%s] is duplicate", router.key()));
//                }
//                monoExtPoints.put(key, monoExt);
//                log.warn("MonoExtPoint:{}", key);
//            }
//        }
//
//        @Autowired
//        public void setBiExtPoints(Collection<BiExtPoint> biExtList) {
//            for (BiExtPoint biExt : emptyIfNull(biExtList)) {
//                CommRouter router = biExt.getClass().getAnnotation(CommRouter.class);
//                if (Objects.isNull(router)) {
//                    throw new RuntimeException("router annotation cannot be null");
//                }
//                if (Strings.isBlank(router.key())) {
//                    throw new RuntimeException("router key cannot be null");
//                }
//                String key = buildRouterKey(router.key(), router.scene());
//                if (biExtPoints.containsKey(key)) {
//                    throw new RuntimeException(String.format("key[%s] is duplicate", router.key()));
//                }
//                biExtPoints.put(key, biExt);
//                log.warn("BiExtPoint:{}", key);
//            }
//        }
//
//        @Autowired
//        public void setTriExtPoints(Collection<TriExtPoint> triExtList) {
//            for (TriExtPoint triExt : emptyIfNull(triExtList)) {
//                CommRouter router = triExt.getClass().getAnnotation(CommRouter.class);
//                if (Objects.isNull(router)) {
//                    throw new RuntimeException("router annotation cannot be null");
//                }
//                if (Strings.isBlank(router.key())) {
//                    throw new RuntimeException("router key cannot be null");
//                }
//                String key = buildRouterKey(router.key(), router.scene());
//                if (triExtPoints.containsKey(key)) {
//                    throw new RuntimeException(String.format("key[%s] is duplicate", router.key()));
//                }
//                triExtPoints.put(key, triExt);
//                log.warn("TriExtPoint:{}", key);
//            }
//        }
//
//        public static <P, R> MonoExtPoint<P, R> getMonoExtPoint(String key, RouterScene scene, MonoExtPoint<P, R> defaultFuc) {
//            if (Strings.isBlank(key) || Objects.isNull(scene)) {
//                return defaultFuc;
//            }
//            String _key = buildRouterKey(key, scene);
//            return (param) -> {
//                try {
//                    MonoExtPoint<P, R> monoExtPoint = monoExtPoints.get(_key);
//                    if (monoExtPoint != null) {
//                        return monoExtPoint.execExt(param);
//                    } else {
//                        log.warn(String.format("key:[%s] not find implement", _key));
//                    }
//                } catch (Throwable e) {
//                    log.error(String.format("key:[%s] execute error", _key), e);
//                    return null;
//                }
//                return defaultFuc.execExt(param);
//            };
//        }
//
//        public static <P1, P2, R> BiExtPoint<P1, P2, R> getBiExtPoint(String key, RouterScene scene, BiExtPoint<P1, P2, R> defaultFuc) {
//            if (Strings.isBlank(key) || Objects.isNull(scene)) {
//                return defaultFuc;
//            }
//            String _key = buildRouterKey(key, scene);
//            return (param1, param2) -> {
//                try {
//                    BiExtPoint<P1, P2, R> biExtPoint = biExtPoints.get(_key);
//                    if (biExtPoint != null) {
//                        return biExtPoint.execExt(param1, param2);
//                    } else {
//                        log.warn(String.format("key:[%s] not find implement", _key));
//                    }
//                } catch (Throwable e) {
//                    log.error(String.format("key:[%s] execute error", _key), e);
//                    return null;
//                }
//                return defaultFuc.execExt(param1, param2);
//            };
//        }
//
//        public static <P1, P2, P3, R> TriExtPoint<P1, P2, P3, R> getTriExtPoint(String key, RouterScene scene, TriExtPoint<P1, P2, P3, R> defaultFunc) {
//            if (Strings.isBlank(key) || Objects.isNull(scene)) {
//                return defaultFunc;
//            }
//            String _key = buildRouterKey(key, scene);
//            return (param1, param2, param3) -> {
//                try {
//                    TriExtPoint<P1, P2, P3, R> triExtPoint = triExtPoints.get(_key);
//                    if (triExtPoint != null) {
//                        return triExtPoint.execExt(param1, param2, param3);
//                    } else {
//                        log.warn(String.format("key:[%s] not find implement", _key));
//                    }
//                } catch (Throwable e) {
//                    log.error(String.format("key:[%s] execute error", _key), e);
//                    return null;
//                }
//                return defaultFunc.execExt(param1, param2, param3);
//            };
//        }
//
//        private static String buildRouterKey(String key, RouterScene scene) {
//            return String.format("%s_%s", scene.name(), key);
//        }
//
//
//    }
}
