package net.cforce.huang.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * 图片工具类
 * Created by huang on 2016/9/27.
 */
public class ImageKit {

    private ImageKit(){
        throw new AssertionError();
    }


    /**
     * 返回bitmap的bytes数组的总数
     */
    private static int getBitmapBytesCount(Bitmap bmp) {
        if (bmp == null)
            return 0;
        return bmp.getRowBytes() * bmp.getHeight();
    }

    /**
     * 获取bitmap的宽高及字节总数
     *
     * @param bmp
     * @return
     */
    public static String getBitmapInfo(Bitmap bmp) {
        if (bmp == null)
            return null;
        return String.format("width=%s, height=%s, bytes=%s(b)", bmp.getWidth(), bmp.getHeight(), getBitmapBytesCount(bmp));
    }

    /**
     * 旋转图片
     * @param src       源图片
     * @param degrees   旋转角度
     * @return          旋转后的图片
     */
    public static Bitmap rotate(Bitmap src, int degrees){
        return rotate(src, degrees, src.getWidth()/2, src.getHeight()/2, false);
    }

    /**
     * 旋转图片
     *
     * @param src     源图片
     * @param degrees 旋转角度
     * @param px      旋转点横坐标
     * @param py      旋转点纵坐标
     * @return 旋转后的图片
     */
    public static Bitmap rotate(Bitmap src, int degrees, float px, float py) {
        return rotate(src, degrees, px, py, false);
    }

    /**
     * 旋转图片
     *
     * @param src     源图片
     * @param degrees 旋转角度
     * @param px      旋转点横坐标
     * @param py      旋转点纵坐标
     * @param recycle 是否回收
     * @return 旋转后的图片
     */
    public static Bitmap rotate(Bitmap src, int degrees, float px, float py, boolean recycle) {
        if (isEmptyBitmap(src)) return null;
        if (degrees == 0) return src;
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees, px, py);
        Bitmap ret = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        if (recycle && !src.isRecycled()) src.recycle();
        return ret;
    }

    /**
     * 圆形图片(把一个图片处理成圆形的图片， 如果图片长宽不等，是否裁剪图片，取图片中间一部分进行圆角处理)
     *
     * @param bitmap
     * @return
     */
    public static Bitmap toRound(Bitmap bitmap) {
        return toRound(bitmap, true);
    }

    /**
     * 圆形图片(把一个图片处理成圆形的图片)
     *
     * @param bitmap
     * @param isClip
     *            如果图片长宽不等，是否裁剪图片，取图片中间一部分进行圆角处理
     * @return
     */
    public static Bitmap toRound(Bitmap bitmap, boolean isClip) {
        if (bitmap == null)
            return null;
        if (isClip && bitmap.getWidth() != bitmap.getHeight()) {
            bitmap = clipBitmap(bitmap);
        }
        return toRound(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
    }

    /**
     * 圆角图片(处理方法是在canvas上画一个圆角矩形，然后把目标bitmap画在圆角矩形上)
     *
     * @param bitmap    原始bitmap
     * @param roundPx   圆角的x半径
     * @param roundPy   圆角的y半径
     * @return          圆角图片bitmap
     */
    public static Bitmap toRound(Bitmap bitmap, float roundPx, float roundPy) {
        if (bitmap == null)
            return null;
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);

        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);

        canvas.drawColor(Color.TRANSPARENT);

        canvas.drawRoundRect(rectF, roundPx, roundPy, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    /**
     * 裁剪图片到一个正方形图片，根据图片宽高取图片中间的部分
     */
    public static Bitmap clipBitmap(Bitmap bitmap) {
        if (bitmap == null)
            return null;
        Rect rectOrg = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rectClip = clipRect(rectOrg);
        return clipBitmap(bitmap, rectClip);
    }

    /**
     * 把一个矩形裁剪成一个正方形，如果宽度、高度不相等，根据宽高来裁剪中间一部分
     *
     * @param orgRect
     * @return
     */
    public static Rect clipRect(Rect orgRect) {
        int left = orgRect.left, right = orgRect.right, top = orgRect.top, bottom = orgRect.bottom;
        int orgW = orgRect.width();
        int orgH = orgRect.height();
        if (orgH > orgW) {
            top += (orgH - orgW) / 2;
            bottom = top + orgW;
        } else if (orgH < orgW) {
            left += (orgW - orgH) / 2;
            right = left + orgH;
        }
        return new Rect(left, top, right, bottom);
    }

    /**
     * 裁剪图片(通过画布取图片的一部分)
     *
     * @param desRect
     *            裁剪图片的目标区域,默认图片左上角为（0,0）
     */
    public static Bitmap clipBitmap(Bitmap bitmap, Rect desRect) {
        if (bitmap == null)
            return null;
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        if (desRect.left < 0)
            desRect.left = 0;

        if (desRect.right > w)
            desRect.right = w;

        if (desRect.top < 0)
            desRect.top = 0;

        if (desRect.bottom > h)
            desRect.bottom = h;

        if (desRect.left >= desRect.right || desRect.top >= desRect.bottom) {
            return null;
        }

        Bitmap bmp = Bitmap.createBitmap(desRect.width(), desRect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        canvas.drawBitmap(bitmap, desRect, new RectF(0, 0, desRect.width(), desRect.height()), new Paint());
        return bmp;
    }

    /**
     * 缩放图片
     *
     * @param src       源图片
     * @param newWidth  新宽度
     * @param newHeight 新高度
     * @return 缩放后的图片
     */
    public static Bitmap scale(Bitmap src, int newWidth, int newHeight) {
        return scale(src, newWidth, newHeight, false);
    }

    /**
     * 缩放图片
     *
     * @param src       源图片
     * @param newWidth  新宽度
     * @param newHeight 新高度
     * @param recycle   是否回收
     * @return 缩放后的图片
     */
    public static Bitmap scale(Bitmap src, int newWidth, int newHeight, boolean recycle) {
        if (isEmptyBitmap(src)) return null;
        Bitmap ret = Bitmap.createScaledBitmap(src, newWidth, newHeight, true);
        if (recycle && !src.isRecycled()) src.recycle();
        return ret;
    }

    /**
     * 缩放图片
     *
     * @param src         源图片
     * @param scaleWidth  缩放宽度倍数
     * @param scaleHeight 缩放高度倍数
     * @return 缩放后的图片
     */
    public static Bitmap scale(Bitmap src, float scaleWidth, float scaleHeight) {
        return scale(src, scaleWidth, scaleHeight, false);
    }

    /**
     * 缩放图片
     *
     * @param src         源图片
     * @param scaleWidth  缩放宽度倍数
     * @param scaleHeight 缩放高度倍数
     * @param recycle     是否回收
     * @return 缩放后的图片
     */
    public static Bitmap scale(Bitmap src, float scaleWidth, float scaleHeight, boolean recycle) {
        if (isEmptyBitmap(src)) return null;
        Matrix matrix = new Matrix();
        matrix.setScale(scaleWidth, scaleHeight);
        Bitmap ret = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        if (recycle && !src.isRecycled()) src.recycle();
        return ret;
    }

    /**
     * 判断bitmap对象是否为空
     *
     * @param src 源图片
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private static boolean isEmptyBitmap(Bitmap src) {
        return src == null || src.getWidth() == 0 || src.getHeight() == 0;
    }
}
