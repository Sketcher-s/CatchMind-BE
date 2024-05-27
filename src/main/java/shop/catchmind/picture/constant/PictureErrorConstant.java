package shop.catchmind.picture.constant;

public final class PictureErrorConstant {

    private PictureErrorConstant() {}

    public static final String ID_NOT_BLANK= "id는 null이거나 빈칸일 수 없습니다.";

    public static final String TITLE_NOT_BLANK = "title은 null이거나 빈칸일 수 없습니다.";
    public static final String TITLE_SIZE = "title은 15자를 넘길 수 없습니다.";

    public static final String NOT_FOUND = "해당 그림 검사를 찾을 수 없습니다.";
    public static final String UNMATCHED_MEMBER_PICTURE = "해당 유저의 그림이 아닙니다.";
}
