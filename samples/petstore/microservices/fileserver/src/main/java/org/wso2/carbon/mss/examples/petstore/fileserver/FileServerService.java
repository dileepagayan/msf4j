/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.mss.examples.petstore.fileserver;

import io.netty.buffer.ByteBuf;
import org.wso2.carbon.mss.HttpResponder;
import org.wso2.carbon.mss.HttpStreamHandler;
import org.wso2.carbon.mss.HttpStreamer;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/fs")
public class FileServerService {

    @POST
    @Path("/{fileName}")
    public void postFile(@Context HttpStreamer httpStreamer,
                         @PathParam("fileName") String fileName) {
        httpStreamer.callback(new HttpStreamHandlerImpl(fileName));
    }

    @POST
    @Path("/{fileName}")
    public Response getFile(@PathParam("fileName") String fileName) {
        return null;
    }

    private static class HttpStreamHandlerImpl implements HttpStreamHandler {
        private final String fileName;

        public HttpStreamHandlerImpl(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void chunk(ByteBuf request, HttpResponder responder) {

        }

        @Override
        public void finished(ByteBuf request, HttpResponder responder) {

        }

        @Override
        public void error(Throwable cause) {

        }
    }
}
