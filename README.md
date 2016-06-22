# SwipeRecyclerView
    仿QQ侧滑的RecyclerView
----------------------------------------------------------------------------
# 使用方法
### 1. AndroidStudio
    首先确保AndroidStudio对jcenter支持 （AndroidStudio v1.2以上默认使用jcenter，此处可以不用修改，只需修改Moudle的build.gradle即可）
     project的build.gradle中()
```xml
     repositories {
            jcenter()
         }
```
     在Moudle的build.gradle的dependencies中加入如下代码
```xml
    compile 'com.lixiaohui8636:swipe-recycler-view:1.0'
```
### 2.eclipse
    添加arr文件到libs
[点击下载arr文件](http://pan.baidu.com/s/1c2JmJlA)

------------------------------------------------------------------------------------
# 示例代码
### Layout配置
```xml
<?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
                android:background="#B6B6B6">
        <com.lixiaohui8636.widget.SwipeRecyclerView
            xmlns:swipe="http://schemas.android.com/apk/res-auto"
            android:id="@+id/example_lv_list"
            android:listSelector="#00000000"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            swipe:swipeFrontView="@+id/front"
            swipe:swipeBackView="@+id/back"
            swipe:swipeOffsetLeft="25dp"
            swipe:swipeDrawableChecked="@drawable/choice_selected"
            swipe:swipeDrawableUnchecked="@drawable/choice_unselected"
            swipe:swipeCloseAllItemsWhenMoveList="true"
            swipe:swipeMode="left"
            swipe:onlyOneOpenedWhenSwipe="true"
            />
</LinearLayout>
```
### JAVA
```java
     swipeListView = (SwipeRecyclerView) findViewById(R.id.example_lv_list);
     mLayoutManager = new LinearLayoutManager(this);
     swipeListView.setLayoutManager(mLayoutManager);
     swipeListView.addItemDecoration(new RecyclerViewItemDecoration(10));
     swipeListView.setAdapter(adapter);
     swipeListView.addOnItemTouchListener(
         new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
              @Override public void onItemClick(View view, int position) {
                                Toast.makeText(SwipeListViewExampleActivity.this,""+position,Toast.LENGTH_LONG).show();
                            }
                        })
                );

 public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
     private OnItemClickListener mListener;

     public interface OnItemClickListener {
         public void onItemClick(View view, int position);
     }

     GestureDetector mGestureDetector;

     public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
         mListener = listener;
         mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
             @Override
             public boolean onSingleTapUp(MotionEvent e) {
                 return true;
             }
         });
     }

     @Override
     public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
         View childView = view.findChildViewUnder(e.getX(), e.getY());
         if(childView==null)return true;
         View frontView=childView.findViewById(R.id.front);
         if(frontView==null)return true;
         if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)&&frontView.isClickable()) {
             mListener.onItemClick(childView, view.getChildPosition(childView));
             return true;
         }
         return false;
     }

     @Override
     public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

     @Override
     public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

     }
 }
```
-------------------------------------------------------------------------------------
# 效果图
![image](https://github.com/lixiaohui8636/SwipeRecyclerView/blob/master/aa.png)