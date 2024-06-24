package com.yc.example.gobrs_async.service;

import com.gobrs.async.GobrsAsync;
import com.gobrs.async.engine.RuleThermalLoad;
import com.gobrs.async.rule.Rule;
import com.gobrs.async.task.AsyncTask;
import com.yc.example.gobrs_async.task.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: youcong
 */
@Service
public class GobrsService {

    @Autowired
    private AService aService;

    @Autowired
    private BService bService;
    @Autowired
    private CService cService;
    @Autowired
    private DService dService;

    @Autowired
    private EService eService;

    @Autowired
    private FService fService;

    @Autowired
    private GService gService;

    @Resource
    private GobrsAsync gobrsAsync;

    @Resource
    private RuleThermalLoad ruleThermalLoad;

    /**
     * The Executor service.
     */
    ExecutorService executorService = Executors.newCachedThreadPool();


    /**
     * Gobrs async.
     */
    public void gobrsAsync() {
        gobrsAsync.go("test", () -> new Object());
    }


    /**
     * Future.
     */
    public void future() {
        List<AsyncTask> abList = new ArrayList<>();
        abList.add(aService);
        abList.add(bService);
        List<Future> futures = new ArrayList<>();
        for (AsyncTask task : abList) {
            Future<Object> submit = executorService.submit(() -> task.task(new Object(), null));
            futures.add(submit);
        }

        for (Future future : futures) {
            try {
                Object o = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        List<AsyncTask> cdList = new ArrayList<>();
        cdList.add(cService);
        cdList.add(dService);
        List<Future> futurescd = new ArrayList<>();
        for (AsyncTask task : cdList) {
            Future<Object> submit = executorService.submit(() -> task.task(new Object(), null));
            futurescd.add(submit);
        }

        for (Future future : futurescd) {
            try {
                Object o = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        List<AsyncTask> efList = new ArrayList<>();
        efList.add(eService);
        efList.add(fService);
        List<Future> futuresef = new ArrayList<>();
        for (AsyncTask task : efList) {
            Future<Object> submit = executorService.submit(() -> task.task(new Object(), null));
            futuresef.add(submit);
        }

        for (Future future : futuresef) {
            try {
                Object o = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        Future<Object> submit = executorService.submit(() -> gService.task(new Object(), null));
        try {
            submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    /**
     * Update rule.
     *
     * @param rule the rule
     */
    public void updateRule(Rule rule) {
        Rule r = new Rule();
        r.setName("ruleName");
        r.setContent("AService->CService->EService->GService; BService->DService->FService->HService;");
        ruleThermalLoad.load(rule);
    }
}
