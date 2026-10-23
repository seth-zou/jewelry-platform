package com.sethzou.jewelry.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TraceStateMachineTest {
    private final TraceStateMachine stateMachine = new TraceStateMachine();

    @Test
    void appliesHappyPathTransition() {
        assertThat(stateMachine.apply(AssetStatus.REGISTERED, TraceEventType.CERTIFIED))
                .isEqualTo(AssetStatus.CERTIFIED);
    }

    @Test
    void rejectsInvalidTransition() {
        assertThatThrownBy(() -> stateMachine.apply(AssetStatus.DRAFT, TraceEventType.SOLD))
                .isInstanceOf(IllegalStateException.class);
    }
}
