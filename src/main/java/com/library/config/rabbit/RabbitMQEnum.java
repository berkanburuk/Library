package com.library.config.rabbit;

//@Configuration
public enum RabbitMQEnum {
    QUEUE_DEADLINE_EXCEEDED {
        @Override
        String getValue() {
            return "queueDeadlineExceeded";
        }
    },
    DIRECT_DEADLINE_EXCEEDED {
        @Override
        String getValue() {
            return "directDeadLineExceeded";
        }
    },
    ROUTING_KEY_DEADLINE_EXCEEDED {
        @Override
        String getValue() {
            return "routingDeadlineEx";
        }
    },
    RABBIT_MQ_USERNAME {
        @Override
        String getValue() {
            return "guest";
        }
    },
    RABBIT_MQ_PASSWORD {
        @Override
        String getValue() {
            return "guest";
        }
    },
    RABBIT_MQ_HOSTNAME {
        @Override
        String getValue() {
            return "localhost";
        }
    }, RABBIT_MQ_PORT {
        @Override
        String getValue() {
            return "5672";
        }
    };


    abstract String getValue();

}
