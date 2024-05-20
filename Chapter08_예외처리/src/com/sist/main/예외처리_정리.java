package com.sist.main;
/*
 *     예외처리
 *       = 정의:사전에 에러를 방지하는 프로그램 => 견고성
 *       = 목적:비정상 종료를 방지하고 정상상태를 유지한다
 *     => 종류
 *        직접처리 => 예외 발생시 복구
 *                          --- 복구하는 위치 catch 블록
 *          | try ~ catch ~Finally
 *         간접처리
 *         임의 발생 => 에러가 없는데 임의로 발생 => 테스트
 *          | throw
 *         사용자 정의 => 자바에서 지원하지않는 예외처리를 직접 만들어서 처리
 *          | Exception을 상속받아서 처리 => 사용 빈도는 거의 없다
 *      1. try ~ catch
 *         try
 *         {
 *             정상 수행하는 문장
 *             => 프로그램 수행중에 오류 발생 할 수 있다
 *                => 프로그래머의 실수 , 사용자 입력 문제
 *                                 => 일단 => 조건문
 *         }catch(예외처리클래스)
 *         {
 *             => try수행중에 에러가 발생시 처리하는 영역
 *         }   => catch는 여러개 사용이 가능 => 핵심되는 에러를 바로 설정 => 한개로 처리가 가능
 *                                                             -------------- 속도
 *         finally
 *         {
 *             => 정상 , 에러처리와 관련없이 무조건 수행하는 문장이 있는 경우 ... => 생략 (필요시만 사용_
 *                try   catch
 *         }
 *          
 */
public class 예외처리_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
