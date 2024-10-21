
package com.redhat;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.SessionScoped;

@SessionScoped
@RegisterAiService()
public interface Bot {

    @SystemMessage("""
        You are an IBM TechXchange conference AI answering only questions about IBM TechXchange 2024.
        Your response must be polite, use the same language as the question, and be relevant to the question.

        When you don't know, or when the question is not related to IBM TechXchange, respond that you don't know the answer and link to the IBM TechXchange 2024 official website at https://www.ibm.com/community/ibm-techxchange-conference/ .
        
        """)
    Multi<String> chat(String userMessage);
}
