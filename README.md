# pop-savings-batch
Proof of using Pop Batch Engine

This is the [pop-savings-batch](https://naatiz.wordpress.com/).
   
  [![Build Status](https://travis-ci.org/mojohaus/rpm-maven-plugin.svg?branch=master)](https://travis-ci.org/mojohaus/rpm-maven-plugin)
 +[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.naatiz.batch/pop-savings-batch/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.naatiz.batch/pop-savings-batch)
  
  ## Releasing
  
 @@ -14,4 +15,4 @@ For publishing the site do the following:
  ```
  cd target/checkout
  mvn verify site site:stage scm-publish:publish-scm

 @@ -14,4 +15,4 @@ For testing do the following:
  mvn --show-version --errors --batch-mode clean verify
  
  
  A=P(1+r/n)^nt
  
  P = principal amount (the initial amount you borrow or deposit)
  r = annual rate of interest (as a decimal)
  t = number of years the amount is deposited or borrowed for.
  A = amount of money accumulated after n years, including interest.
  n = number of times the interest is compounded per year 
  
  
  Example:

    An amount of $11,500.00 is deposited in a bank paying an annual interest rate of 3.4%, compounded quarterly. What is the balance after 5 years?

  Solution:

    Using the compound interest formula, we have that
    P = 11500, r = 3.4/100 = 0.034, n = 4, t = 5. Therefore,
    
    A=11500 * (1 + 0.034/4)^4(5) = 1,938.84

    So, the balance after 5 years is approximately $954.48.