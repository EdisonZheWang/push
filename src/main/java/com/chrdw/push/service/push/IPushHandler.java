package com.chrdw.push.service.push;

/**
 * @Date: 12/26/19
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
public interface IPushHandler<Req, Res> {

  Res handlePush(Req req);
}
