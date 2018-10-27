package reference;

import org.junit.jupiter.api.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class AboutReference {

    SoftReference<Object> sf = null;
    WeakReference<Object> wf = null;
    PhantomReference<Object> pf = null;
    ReferenceQueue referenceQueue = new ReferenceQueue();

    /**
     * 测试强引用
     */
    @Test
    public void testStrongReference(){
        Object obj = new String("aaaa");
        System.out.println(obj.toString());
    }

    /**
     * 测试软引用,当软引用的对象被回收后，就不可用了,回收表示在一定gc周期内，没有被引用过，包括没有被softreference的get方法调用过，才会被回收。
     * 如果一直频繁被get，则也不会被回收。
     */
    @Test
    public void testSoftReference(){
        helperSoftReference();
        System.out.println(sf.get());
        String str = null;
        for(int i=0;i<35000;i++){
            str = str + "aaaa";
//            System.out.println("-----------------------"+i+"-----------------------"+sf.get());
        }
        System.out.println(sf.get());
    }

    /**
     * 弱引用测试，当第二次垃圾回收时回收,用来判断对象第一次的垃圾回收标记
     */
    @Test
    public void testWeakReference(){
        helperWeakReference();
        System.out.println(wf.get());
        String str = null;
        int mark = 0;
        for(int i=0;i<35000;i++){
            str = str + "aaaa";
            if(wf.isEnqueued()){
                System.out.println("---------------------"+i+"--------------"+wf.get());
                mark = i;
            }
            if(i > mark){
                System.out.println("---------------------"+i+"--------------"+wf.get());
            }
        }
        System.out.println(wf.get());
    }

    /**
     * 虚引用，判断对象是否在内存中被删除
     */
    @Test
    public void testPhantomReference(){
        helperPhantomReference();
        if(pf.isEnqueued()){
            System.out.println("---------------------------------删除");
        }
        System.out.println(pf.get());
        String str = null;
        int mark = 0;
        for(int i=0;i<35000;i++){
            str = str + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            if(pf.isEnqueued()){
                System.out.println("---------------------"+i+"--------------删除");
                mark = i;
            }
        }
    }

    private void helperSoftReference(){
        Object obj = new String("bbbb");
        sf = new SoftReference<>(obj);
        obj = null;
    }

    private void helperWeakReference(){
        Object obj = new String("testweakreference");
        wf = new WeakReference<>(obj);
        obj = null;
    }

    private void helperPhantomReference(){
        Object obj = new String("PhantomReference");

        pf = new PhantomReference<Object>(obj,referenceQueue);
//        obj = null;
    }
}
