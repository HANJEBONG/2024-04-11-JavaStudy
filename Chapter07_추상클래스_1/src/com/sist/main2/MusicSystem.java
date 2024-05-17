package com.sist.main2;
/*
 *     Music => Genie / Melon
 *     ------ 뮤직을 만들때 => 상속
 */
public abstract class MusicSystem {
    public static Music[] musics=new Music[100];
    public abstract void init(); // 데이터 초기화
    public abstract void find(String title);
    public abstract void list();
    public abstract void detail(int mno);
}
