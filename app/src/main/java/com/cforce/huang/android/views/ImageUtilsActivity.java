package com.cforce.huang.android.views;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cforce.huang.android.R;

import net.cforce.huang.common.utils.ImageKit;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ImageUtils
 * Created by huang on 2016/9/27.
 */
public class ImageUtilsActivity extends BaseActivity {

    private Bitmap bitmap;
    private String orgBitmapInfo;
    private int degree;// 旋转角度

    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.img_org)
    ImageView imgOrg;
    @BindView(R.id.img_filter)
    ImageView imgFilter;
    @BindView(R.id.btn_org)
    Button btnOrg;
    @BindView(R.id.btn_rotate)
    Button btnRotate;
    @BindView(R.id.btn_scale1)
    Button btnScale1;
    @BindView(R.id.btn_scale2)
    Button btnScale2;
    @BindView(R.id.btn_skew)
    Button btnSkew;
    @BindView(R.id.btn_clip)
    Button btnClip;
    @BindView(R.id.btn_compress)
    Button btnCompress;
    @BindView(R.id.btn_translate)
    Button btnTranslate;
    @BindView(R.id.btn_reverse)
    Button btnReverse;
    @BindView(R.id.btn_lian_huan_hua)
    Button btnLianHuanHua;
    @BindView(R.id.btn_rounded_corner)
    Button btnRoundedCorner;
    @BindView(R.id.btn_overlay)
    Button btnOverlay;
    @BindView(R.id.btn_get_bmp)
    Button btnGetBmp;
    @BindView(R.id.btn_bing_dong)
    Button btnBingDong;
    @BindView(R.id.btn_rong_zhu)
    Button btnRongZhu;
    @BindView(R.id.btn_jun_zhi_mo_hu)
    Button btnJunZhiMoHu;
    @BindView(R.id.btn_fast_mo_hu)
    Button btnFastMoHu;
    @BindView(R.id.btn_gao_si_mo_hu)
    Button btnGaoSiMoHu;
    @BindView(R.id.btn_miao_bian)
    Button btnMiaoBian;
    @BindView(R.id.btn_su_miao)
    Button btnSuMiao;
    @BindView(R.id.btn_you_hua)
    Button btnYouHua;
    @BindView(R.id.btn_color)
    Button btnColor;
    @BindView(R.id.btn_rui_hua)
    Button btnRuiHua;
    @BindView(R.id.btn_sui_ji_noise)
    Button btnSuiJiNoise;
    @BindView(R.id.btn_hei_bai)
    Button btnHeiBai;
    @BindView(R.id.btn_yu_hua)
    Button btnYuHua;
    @BindView(R.id.btn_jiao_pian)
    Button btnJiaoPian;
    @BindView(R.id.btn_huai_jiu)
    Button btnHuaiJiu;
    @BindView(R.id.btn_guang_zhao)
    Button btnGuangZhao;
    @BindView(R.id.btn_fu_diao)
    Button btnFuDiao;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_image_util;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        orgBitmapInfo = "原图信息:" + ImageKit.getBitmapInfo(bitmap);
    }

    @OnClick({R.id.btn_org, R.id.btn_rotate, R.id.btn_scale1, R.id.btn_scale2, R.id.btn_skew, R.id.btn_clip, R.id.btn_compress, R.id.btn_translate, R.id.btn_reverse, R.id.btn_lian_huan_hua, R.id.btn_rounded_corner, R.id.btn_overlay, R.id.btn_get_bmp, R.id.btn_bing_dong, R.id.btn_rong_zhu, R.id.btn_jun_zhi_mo_hu, R.id.btn_fast_mo_hu, R.id.btn_gao_si_mo_hu, R.id.btn_miao_bian, R.id.btn_su_miao, R.id.btn_you_hua, R.id.btn_color, R.id.btn_rui_hua, R.id.btn_sui_ji_noise, R.id.btn_hei_bai, R.id.btn_yu_hua, R.id.btn_jiao_pian, R.id.btn_huai_jiu, R.id.btn_guang_zhao, R.id.btn_fu_diao})
    public void onClick(View view) {
        String str = "";
        long start = System.currentTimeMillis();
        switch (view.getId()) {
            case R.id.btn_org:
                str += "原图";
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
                break;
            case R.id.btn_rotate:
                degree = (degree + 45) % 360;
                bitmap = ImageKit.rotate(bitmap, degree);
                str += "旋转";
                break;
            case R.id.btn_scale1:
                Random random = new Random();
                int x = random.nextInt(500);
                int y = random.nextInt(500);

                bitmap = ImageKit.scale(BitmapFactory.decodeResource(getResources(), R.mipmap.test), x, y);
                str += "缩放(指定缩放大小) x=" + x + " y=" + y + ",";
                break;
            case R.id.btn_scale2:

                random = new Random();
                float sx = random.nextFloat() + random.nextFloat();
                float sy = random.nextFloat() + random.nextFloat();
                bitmap = ImageKit.scale(BitmapFactory.decodeResource(getResources(), R.mipmap.test), sx, sy);
                str += "缩放(按比例) x缩放比例=" + sx + ",y缩放比例=" + sy + ",";
                break;
            case R.id.btn_skew:
                break;
            case R.id.btn_clip:
                break;
            case R.id.btn_compress:
                break;
            case R.id.btn_translate:
                break;
            case R.id.btn_reverse:
                break;
            case R.id.btn_lian_huan_hua:
                break;
            case R.id.btn_rounded_corner:
                bitmap = ImageKit.toRound(bitmap);
                str += "圆角";
                break;
            case R.id.btn_overlay:
                break;
            case R.id.btn_get_bmp:
                break;
            case R.id.btn_bing_dong:
                break;
            case R.id.btn_rong_zhu:
                break;
            case R.id.btn_jun_zhi_mo_hu:
                break;
            case R.id.btn_fast_mo_hu:
                break;
            case R.id.btn_gao_si_mo_hu:
                break;
            case R.id.btn_miao_bian:
                break;
            case R.id.btn_su_miao:
                break;
            case R.id.btn_you_hua:
                break;
            case R.id.btn_color:
                break;
            case R.id.btn_rui_hua:
                break;
            case R.id.btn_sui_ji_noise:
                break;
            case R.id.btn_hei_bai:
                break;
            case R.id.btn_yu_hua:
                break;
            case R.id.btn_jiao_pian:
                break;
            case R.id.btn_huai_jiu:
                break;
            case R.id.btn_guang_zhao:
                break;
            case R.id.btn_fu_diao:
                break;
        }
        long end = System.currentTimeMillis();
        str = orgBitmapInfo + "\n" + str + " 处理时间(ms): " + (end - start) + " 处理后图片信息: " + ImageKit.getBitmapInfo(bitmap);

        tvMsg.setText(str);
        imgFilter.setImageBitmap(bitmap);
    }
}
