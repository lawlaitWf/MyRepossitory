package android12.oschina.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ImageViewUtils {

    public static void addImage(Context context, Bitmap bitmap, TextView textView, String title) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        //设置想要的大小
        int newWidth=25;
        int newHeight=30;

        //计算压缩的比率
        float scaleWidth=((float)newWidth)/width;
        float scaleHeight=((float)newHeight)/height;

        //获取想要缩放的matrix
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth,scaleHeight);

        //获取新的bitmap
        bitmap= Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);


        //根据bitmap对象创建imageSpan对象
        ImageSpan imageSpan=new ImageSpan(context, bitmap);
        //创建SpannableString对象，以便插入imageSpan对象封装的图像
        SpannableString spannableString=new SpannableString("icon " + title);
        //用imageSpan对象替换icon
        spannableString.setSpan(imageSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

    }
}
