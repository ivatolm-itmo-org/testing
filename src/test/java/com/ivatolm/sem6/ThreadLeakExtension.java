package com.ivatolm.sem6;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;

public class ThreadLeakExtension implements BeforeEachCallback, AfterEachCallback {

    private Set<Long> unrelatedThreadIds;

    @Override
    public void beforeEach(ExtensionContext context) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        unrelatedThreadIds = new HashSet<>();
        for (ThreadInfo threadInfo : threadInfos) {
            unrelatedThreadIds.add(threadInfo.getThreadId());
        }
    }

    @Override
    public void afterEach(ExtensionContext context) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        List<ThreadInfo> leakedThreads = new ArrayList<>();

        for (ThreadInfo threadInfo : threadInfos) {
            if (!unrelatedThreadIds.contains(threadInfo.getThreadId())
                    && threadInfo.getThreadState() != Thread.State.TERMINATED) {
                    // && !threadInfo.getThreadName().startsWith("Finalizer")
                    // && !threadInfo.getThreadName().startsWith("Reference Handler")) {
                leakedThreads.add(threadInfo);
            }
        }

        if (!leakedThreads.isEmpty()) {
            System.out.println("Possibly leaked threads:");
            for (ThreadInfo threadInfo : leakedThreads) {
                System.out.println(threadInfo.getThreadName()
                        + " [" + threadInfo.getThreadState() + "]");
            }
        }
    }

}
