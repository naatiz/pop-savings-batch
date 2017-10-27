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

  
  A=P(1+r/n)^nt
  
  P = principal amount (the initial amount you borrow or deposit)
  r = annual rate of interest (as a decimal)
  t = number of years the amount is deposited or borrowed for.
  A = amount of money accumulated after n years, including interest.
  n = number of times the interest is compounded per year 
  
  
  Example:

    An amount of $1,500.00 is deposited in a bank paying an annual interest rate of 4.3%, compounded quarterly. What is the balance after 6 years?

  Solution:

    Using the compound interest formula, we have that
    P = 1500, r = 4.3/100 = 0.043, n = 4, t = 6. Therefore,
    
    A=1500 * (1 + 0.043/4)^4(6) = 1,938.84

    So, the balance after 6 years is approximately $1,938.84.