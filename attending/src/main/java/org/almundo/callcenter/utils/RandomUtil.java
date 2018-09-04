package org.almundo.callcenter.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

	public static int randomRango(int desde, int hasta){
		return ThreadLocalRandom.current().nextInt(desde, hasta);
	}
}
