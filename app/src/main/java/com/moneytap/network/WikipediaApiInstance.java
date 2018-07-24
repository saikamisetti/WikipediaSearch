package com.moneytap.network;

/**
 * Singleton instance to access api endpoints.
 */
public class WikipediaApiInstance {

  private static WikipediaApi instance;

  private WikipediaApiInstance() {
  }

  public static void init() {
    instance = NetworkAdapter.getClient()
        .create(WikipediaApi.class);
  }

  public static WikipediaApi getInstance() {
    return instance;
  }
}
